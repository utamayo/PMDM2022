import 'package:curso_firebase_flutter/provider/auth_provider.dart';
import 'package:curso_firebase_flutter/screen/home_screen.dart';
import 'package:curso_firebase_flutter/widget/custom_text_field.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class PhoneAuthScreen extends StatelessWidget {
  const PhoneAuthScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return StreamBuilder<User?>(
        stream: FirebaseAuth.instance.authStateChanges(),
        builder: (context, snapshot) {
          if (snapshot.hasData) {
            return HomeScreen();
          }
          return Scaffold(
            body: Consumer<AuthProvider>(builder: (context, model, _) {
              return Center(
                child: Padding(
                  padding: const EdgeInsets.all(20.0),
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      CustomTextField(
                        controller: model.phoneController,
                        iconData: Icons.phone,
                        hintText: "Introduce el número de teléfono",
                      ),
                      TextButton(
                        onPressed: () {
                          model.verificarNumeroDeTelefono(context);
                        },
                        child: const Text('Enviar OTP'),
                      ),
                    ],
                  ),
                ),
              );
            }),
          );
        });
  }
}
