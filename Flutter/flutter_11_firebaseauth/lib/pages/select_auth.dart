import 'package:flutter/material.dart';

import '../widgets/auth_button.dart';

class SelectAuthPage extends StatelessWidget {
  const SelectAuthPage({super.key});

  @override
  Widget build(BuildContext context) {
    return const Scaffold(
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(20.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(
                'Seleccione el método de autenticación',
                style: TextStyle(fontWeight: FontWeight.bold, fontSize: 18),
              ),
              AuthButton(
                iconData: Icons.email,
                titulo: "Email / Password",
              ),
            ],
          ),
        ),
      ),
    );
  }
}
