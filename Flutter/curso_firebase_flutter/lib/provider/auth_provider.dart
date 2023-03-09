import 'dart:async';
import 'dart:io';

import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:curso_firebase_flutter/keys.dart';
import 'package:curso_firebase_flutter/widget/custom_text_field.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:google_sign_in/google_sign_in.dart';

class AuthProvider extends ChangeNotifier {
  TextEditingController emailController = TextEditingController();
  TextEditingController passController = TextEditingController();
  TextEditingController userNameController = TextEditingController();
  AuthType _authType = AuthType.signIn;
  AuthType get authType => _authType;

  FirebaseAuth firebaseAuth = FirebaseAuth.instance;
  FirebaseFirestore firebaseFirestore = FirebaseFirestore.instance;

  setAuthType() {
    _authType =
        _authType == AuthType.signIn ? AuthType.signUp : AuthType.signIn;
    notifyListeners();
  }

  authenticate() async {
    UserCredential userCredential;
    try {
      if (_authType == AuthType.signUp) {
        userCredential = await firebaseAuth.createUserWithEmailAndPassword(
            email: emailController.text, password: passController.text);
        await userCredential.user!.sendEmailVerification();
        firebaseFirestore
            .collection("users")
            .doc(userCredential.user!.uid)
            .set({
          "email": userCredential.user!.email,
          "uid": userCredential.user!.uid,
          "user_name": userNameController.text
        });
      }
      if (_authType == AuthType.signIn) {
        userCredential = await firebaseAuth.signInWithEmailAndPassword(
            email: emailController.text, password: passController.text);
      }
    } on FirebaseAuthException catch (error) {
      Keys.scaffoldMessengerKey.currentState!.showSnackBar(SnackBar(
        content: Text(error.code),
        backgroundColor: Colors.red,
      ));
    } catch (error) {
      Keys.scaffoldMessengerKey.currentState!.showSnackBar(SnackBar(
        content: Text(error.toString()),
        backgroundColor: Colors.red,
      ));
    }
  }

  bool? emailVerificado;
  updateEmailVerificationState() async {
    emailVerificado = firebaseAuth.currentUser!.emailVerified;

    if (!emailVerificado!) {
      Timer.periodic(const Duration(seconds: 3), (timer) async {
        await firebaseAuth.currentUser!.reload();
        final user = FirebaseAuth.instance.currentUser;
        if (user!.emailVerified) {
          emailVerificado = user.emailVerified;
          timer.cancel();
          notifyListeners();
        }
      });
    }
  }

  TextEditingController resetEmailController = TextEditingController();
  resetearPassord(BuildContext context) {
    showDialog(
      context: context,
      builder: (_) {
        return AlertDialog(
          title: const Text('Introduce tu email'),
          content: CustomTextField(
            controller: resetEmailController,
            iconData: Icons.email,
            hintText: "Introduce email",
          ),
          actions: [
            TextButton(
              onPressed: () async {
                final navigator = Navigator.of(context).pop();
                try {
                  await firebaseAuth.sendPasswordResetEmail(
                      email: resetEmailController.text);
                  Keys.scaffoldMessengerKey.currentState!
                      .showSnackBar(const SnackBar(
                    content: Text('Email enviado correctamente!!'),
                    backgroundColor: Colors.green,
                  ));
                } catch (e) {
                  Keys.scaffoldMessengerKey.currentState!.showSnackBar(SnackBar(
                    content: Text(e.toString()),
                    backgroundColor: Colors.red,
                  ));
                  navigator;
                }
              },
              child: const Text('Aceptar'),
            )
          ],
        );
      },
    );
  }

  //  Autenticación mediante TELEFONO
  TextEditingController phoneController = TextEditingController(text: '+');
  verificarNumeroDeTelefono(BuildContext context) async {
    try {
      await firebaseAuth.verifyPhoneNumber(
        phoneNumber: phoneController.text,
        timeout: const Duration(seconds: 30),
        verificationCompleted: (AuthCredential authCredencial) {
          Keys.scaffoldMessengerKey.currentState!.showSnackBar(const SnackBar(
            content: Text('Verificación completada.'),
            backgroundColor: Colors.green,
          ));
        },
        verificationFailed: (FirebaseAuthException exception) {
          Keys.scaffoldMessengerKey.currentState!.showSnackBar(const SnackBar(
            content: Text('Fallo al verificar.'),
            backgroundColor: Colors.red,
          ));
        },
        codeSent: (String? verId, int? forceCodeResent) {
          Keys.scaffoldMessengerKey.currentState!.showSnackBar(const SnackBar(
            content: Text('Codigo enviado satisfactoriamente'),
            backgroundColor: Colors.green,
          ));
          verificationId = verId;
          // opt dialog box
          optDialogBox(context);
        },
        codeAutoRetrievalTimeout: (String verId) {
          Keys.scaffoldMessengerKey.currentState!.showSnackBar(const SnackBar(
            content: Text('Tiempo agotado.'),
            backgroundColor: Colors.red,
          ));
        },
      );
    } on FirebaseAuthException catch (e) {
      Keys.scaffoldMessengerKey.currentState!.showSnackBar(SnackBar(
        content: Text(e.message!),
        backgroundColor: Colors.red,
      ));
    }
  }

  String? verificationId;
  TextEditingController optController = TextEditingController();
  optDialogBox(BuildContext context) {
    return showDialog(
        context: context,
        builder: (_) {
          return AlertDialog(
            title: const Text('Introduce tu OPT'),
            content: CustomTextField(
                controller: optController,
                iconData: Icons.code,
                hintText: "Introduce OPT"),
            actions: [
              TextButton(
                  onPressed: () {
                    signInConTelefono();
                  },
                  child: const Text('Enviar')),
            ],
          );
        });
  }

  signInConTelefono() async {
    await firebaseAuth.signInWithCredential(
      PhoneAuthProvider.credential(
        verificationId: verificationId!,
        smsCode: optController.text,
      ),
    );
  }

  GoogleSignIn googleSignIn = GoogleSignIn();

  signInWhithGoogle() async {
    GoogleSignInAccount? googleSignInAccount = await googleSignIn.signIn();

    if (googleSignInAccount != null) {
      try {
        GoogleSignInAuthentication googleSignInAuthentication =
            await googleSignInAccount.authentication;
        AuthCredential authCredential = GoogleAuthProvider.credential(
            accessToken: googleSignInAuthentication.accessToken,
            idToken: googleSignInAuthentication.idToken);

        await firebaseAuth.signInWithCredential(authCredential);
        print(googleSignInAccount.photoUrl);
        print(googleSignInAccount.displayName);
        print(googleSignInAccount.email);
      } on FirebaseAuthException catch (e) {
        Keys.scaffoldMessengerKey.currentState!.showSnackBar(SnackBar(
          content: Text(e.message!),
          backgroundColor: Colors.red,
        ));
      }
    } else {
      Keys.scaffoldMessengerKey.currentState!.showSnackBar(const SnackBar(
        content: Text('Cuenta no seleccionada'),
        backgroundColor: Colors.red,
      ));
    }
  }

  logOut() async {
    try {
      await firebaseAuth.signOut();
      await googleSignIn.signOut();
    } catch (error) {
      Keys.scaffoldMessengerKey.currentState!.showSnackBar(SnackBar(
        content: Text(error.toString()),
        backgroundColor: Colors.red,
      ));
    }
  }
}

enum AuthType {
  signUp,
  signIn,
}
