import 'package:flutter/material.dart';
import 'package:flutter_04_componentes/widgets/custom_input_widget.dart';

class FormularioPage extends StatelessWidget {
  const FormularioPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Formulario')),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 10),
          child: Column(
            children: const [
              CustomInputWidget(
                labelText: 'Nombre',
                hintText: 'Nombre del usuario',
                icon: Icons.verified_user_outlined,
              ),
              SizedBox(
                height: 30,
              ),
              CustomInputWidget(
                labelText: 'Apellido',
                hintText: 'Apellido del usuario',
                icon: Icons.verified_user_outlined,
              ),
              SizedBox(
                height: 30,
              ),
              CustomInputWidget(
                labelText: 'Correo',
                hintText: 'Correo del usuario',
                icon: Icons.email_outlined,
                suffixIcon: Icons.email_outlined,
                teclado: TextInputType.emailAddress,
              ),
              SizedBox(
                height: 30,
              ),
              CustomInputWidget(
                labelText: 'Contraseña',
                hintText: 'Password del usuario',
                icon: Icons.password_outlined,
                obscureText: true,
              ),
              SizedBox(
                height: 30,
              ),
            ],
          ),
        ),
      ),
    );
  }
}
