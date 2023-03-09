import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:flutter_09_firebaseauth/pages/estudiante/home_estudiante.dart';
import 'package:flutter_09_firebaseauth/provider/auth_provider.dart';
import 'package:provider/provider.dart';

class LoginPage extends StatelessWidget {
  const LoginPage({super.key});

  @override
  Widget build(BuildContext context) {
    final provider = Provider.of<AuthProvider>(context);
    return Consumer<AuthProvider>(builder: (context, model, _) {
      return StreamBuilder(
        stream: FirebaseAuth.instance.authStateChanges(),
        builder: (context, snapshot) {
          if (!snapshot.hasData) {
            return Scaffold(
              body: Padding(
                padding: EdgeInsets.all(15.0),
                child: Center(
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      SizedBox(
                        height: 40,
                        child: TextField(
                          controller: provider.emailController,
                          decoration:
                              InputDecoration(prefixIcon: Icon(Icons.email)),
                        ),
                      ),
                      SizedBox(
                        height: 40,
                        child: TextField(
                          controller: provider.passwordController,
                          decoration:
                              InputDecoration(prefixIcon: Icon(Icons.password)),
                        ),
                      ),
                      TextButton(
                        onPressed: null,
                        child: Text('Entrar'),
                      ),
                      TextButton(
                        onPressed: () {
                          provider.registrarUsuario(context);
                        },
                        child: Text('Registrarse'),
                      ),
                    ],
                  ),
                ),
              ),
            );
          } else {
            return const HomeEstudiantePage();
          }
        },
      );
    });
  }
}
