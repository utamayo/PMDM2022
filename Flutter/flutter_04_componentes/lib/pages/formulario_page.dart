import 'package:flutter/material.dart';
import 'package:flutter_04_componentes/widgets/custom_input_widget.dart';

class FormularioPage extends StatelessWidget {
  const FormularioPage({super.key});

  @override
  Widget build(BuildContext context) {
    final GlobalKey<FormState> myFormKey = GlobalKey<FormState>();

    final Map<String, String> resultadosFormulario = {
      'nombre': 'Alberto',
      'apellido': 'Rodriguez',
      'email': 'alberto@gmail.com',
      'password': '123456',
      'rol': 'Admin',
    };

    return Scaffold(
      appBar: AppBar(title: const Text('Formulario')),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 10),
          child: Form(
            key: myFormKey,
            child: Column(
              children: [
                const CustomInputWidget(
                  labelText: 'Nombre',
                  hintText: 'Nombre del usuario',
                  icon: Icons.verified_user_outlined,
                ),
                const SizedBox(
                  height: 30,
                ),
                const CustomInputWidget(
                  labelText: 'Apellido',
                  hintText: 'Apellido del usuario',
                  icon: Icons.verified_user_outlined,
                ),
                const SizedBox(
                  height: 30,
                ),
                const CustomInputWidget(
                  labelText: 'Correo',
                  hintText: 'Correo del usuario',
                  icon: Icons.email_outlined,
                  suffixIcon: Icons.email_outlined,
                  teclado: TextInputType.emailAddress,
                ),
                const SizedBox(
                  height: 30,
                ),
                const CustomInputWidget(
                  labelText: 'Contraseña',
                  hintText: 'Password del usuario',
                  icon: Icons.password_outlined,
                  obscureText: true,
                ),
                const SizedBox(
                  height: 30,
                ),

                // Botón para enviar Formulario
                ElevatedButton(
                  onPressed: () {
                    //Quiero que desaparezca el teclado
                    FocusScope.of(context).requestFocus(FocusNode());

                    if (!myFormKey.currentState!.validate()) {
                      print('Formulario NO válido');
                      return;
                    }

                    print(resultadosFormulario);
                  },
                  child: const Center(
                    child: Text('Guardar'),
                  ),
                )
              ],
            ),
          ),
        ),
      ),
    );
  }
}
