import 'package:curso_firebase_flutter/screen/email_pass_screen.dart';
import 'package:curso_firebase_flutter/screen/google_sign_in_screen.dart';
import 'package:curso_firebase_flutter/screen/phone_auth_screen.dart';
import 'package:curso_firebase_flutter/widget/auth_button.dart';
import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';

class AuthScreen extends StatelessWidget {
  const AuthScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(20.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              const Text(
                'Seleccione Modo de Autenticación:',
                style: TextStyle(fontWeight: FontWeight.bold, fontSize: 20),
              ),
              AuthButton(
                  iconData: Icons.email,
                  title: "Email/Password",
                  onTap: () {
                    Navigator.of(context).push(MaterialPageRoute(
                        builder: (_) => const EmailPassScreen()));
                  }),
              AuthButton(
                  iconData: Icons.email,
                  title: "Teléfono (SMS)",
                  onTap: () {
                    Navigator.of(context).push(MaterialPageRoute(
                        builder: (_) => const PhoneAuthScreen()));
                  }),
              AuthButton(
                  iconData: FontAwesomeIcons.google,
                  title: "Google",
                  onTap: () {
                    Navigator.of(context).push(MaterialPageRoute(
                        builder: (_) => const GoogleSignInScreen()));
                  }),
            ],
          ),
        ),
      ),
    );
  }
}
