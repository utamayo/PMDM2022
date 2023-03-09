import 'package:flutter/material.dart';

class LoginPage extends StatelessWidget {
  const LoginPage({super.key});

  @override
  Widget build(BuildContext context) {
    return const Scaffold(
      body: Padding(
        padding: EdgeInsets.all(15.0),
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              SizedBox(
                height: 40,
                child: TextField(
                  //controller: controller,
                  decoration: InputDecoration(prefixIcon: Icon(Icons.email)),
                ),
              ),
              SizedBox(
                height: 40,
                child: TextField(
                  //controller: controller,
                  decoration: InputDecoration(prefixIcon: Icon(Icons.password)),
                ),
              ),
              TextButton(
                onPressed: null,
                child: Text('Entrar'),
              ),
              TextButton(
                onPressed: null,
                child: Text('Registrarse'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
