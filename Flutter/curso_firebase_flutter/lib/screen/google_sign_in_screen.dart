import 'package:curso_firebase_flutter/provider/auth_provider.dart';
import 'package:curso_firebase_flutter/screen/home_screen.dart';
import 'package:curso_firebase_flutter/widget/auth_button.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:provider/provider.dart';

class GoogleSignInScreen extends StatelessWidget {
  const GoogleSignInScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return StreamBuilder(
        stream: FirebaseAuth.instance.authStateChanges(),
        builder: (context, snapshot) {
          if (snapshot.hasData) {
            return HomeScreen();
          }
          return Scaffold(
            body: Consumer<AuthProvider>(builder: (context, model, _) {
              return Padding(
                padding: const EdgeInsets.all(20.0),
                child: Center(
                  child: AuthButton(
                      iconData: FontAwesomeIcons.google,
                      title: "Google",
                      onTap: () {
                        model.signInWhithGoogle();
                      }),
                ),
              );
            }),
          );
        });
  }
}
