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
                CustomInputWidget(
                  labelText: 'Nombre',
                  hintText: 'Nombre del usuario',
                  icon: Icons.verified_user_outlined,
                  formProperty: 'nombre',
                  formValues: resultadosFormulario,
                ),
                const SizedBox(
                  height: 30,
                ),
                CustomInputWidget(
                  labelText: 'Apellido',
                  hintText: 'Apellido del usuario',
                  icon: Icons.verified_user_outlined,
                  formProperty: 'apellido',
                  formValues: resultadosFormulario,
                ),
                const SizedBox(
                  height: 30,
                ),
                CustomInputWidget(
                  labelText: 'Correo',
                  hintText: 'Correo del usuario',
                  icon: Icons.email_outlined,
                  suffixIcon: Icons.email_outlined,
                  teclado: TextInputType.emailAddress,
                  formProperty: 'email',
                  formValues: resultadosFormulario,
                ),
                const SizedBox(
                  height: 30,
                ),
                CustomInputWidget(
                  labelText: 'Contraseña',
                  hintText: 'Password del usuario',
                  icon: Icons.password_outlined,
                  obscureText: true,
                  formProperty: 'password',
                  formValues: resultadosFormulario,
                ),
                const SizedBox(
                  height: 30,
                ),

                // DropDown Seleccionable
                DropdownButtonFormField(
                    value: 'Admin',
                    items: const [
                      DropdownMenuItem(value: 'Admin', child: Text('Admin')),
                      DropdownMenuItem(
                          value: 'SuperUser', child: Text('Super Usuario')),
                      DropdownMenuItem(
                          value: 'Developer', child: Text('Desarrollador')),
                      DropdownMenuItem(
                          value: 'JRDeveloper',
                          child: Text('Desarrollador Jr')),
                    ],
                    onChanged: (valor) {
                      //print(valor);
                      // Se lo asigno a mi resultado
                      resultadosFormulario['rol'] = valor ?? 'Admin';
                    }),
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
