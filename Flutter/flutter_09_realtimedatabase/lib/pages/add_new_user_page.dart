import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import '../model/user.dart';

class AddNewUserPage extends StatefulWidget {
  final User? user;
  const AddNewUserPage({super.key, this.user});

  @override
  State<AddNewUserPage> createState() => _AddNewUserPageState();
}

class _AddNewUserPageState extends State<AddNewUserPage> {
  final _formKey = GlobalKey<FormState>();
  final emailRegExp = RegExp(
    r"^[a-zA-Z0-9.a-zA-Z0-9.!#$%&'*+-/=?^_`{|}~]+@[a-zA-Z0-9]+\.[a-zA-Z]+",
  );
  TextEditingController usernameController = TextEditingController();
  TextEditingController emailController = TextEditingController();
  TextEditingController phoneNumberController = TextEditingController();
  bool isLoading = false;

  // Añadir Usuario a RealTime Database
  sendUserOnFirebase() async {
    setState(() {
      isLoading = true;
    });

    final response = await http.post(
      Uri.parse(
          'https://fir-flutterdam23-default-rtdb.europe-west1.firebasedatabase.app/usuarios.json'),
      body: jsonEncode({
        "username": usernameController.text,
        "email": emailController.text,
        "phoneNumber": phoneNumberController.text,
      }),
    );
    print(response.statusCode);
    print(response.body);
    if (response.statusCode == 200) {
      usernameController = TextEditingController();
      emailController = TextEditingController();
      phoneNumberController = TextEditingController();
      ScaffoldMessenger.of(context).showSnackBar(const SnackBar(
        content: Text(
          'usuario añadido correctamente',
        ),
        backgroundColor: Colors.green,
      ));
    } else {
      ScaffoldMessenger.of(context).showSnackBar(const SnackBar(
        content: Text(
          'Error al añadir usuario',
        ),
        backgroundColor: Colors.red,
      ));
    }

    setState(() {
      isLoading = false;
    });
  }

  updateUser() async {
    // Actualizar usuario
  }

  @override
  void initState() {
    //Cargamos la información del usuario si se trata de actualizar
    if (widget.user != null) {
      usernameController = TextEditingController(text: widget.user!.username);
      emailController = TextEditingController(text: widget.user!.email);
      phoneNumberController =
          TextEditingController(text: widget.user!.phoneNumber);
    }
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Añadir Nuevo Usuario'),
        elevation: 0,
      ),
      body: Form(
        key: _formKey,
        child: Padding(
          padding: const EdgeInsets.all(15.0),
          child: Column(
            children: [
              TextFormField(
                controller: usernameController,
                cursorColor: Colors.black,
                keyboardType: TextInputType.text,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Por favor, introduzca nombre de usuario';
                  }
                  return null;
                },
                decoration: InputDecoration(
                  filled: true,
                  labelText: "Nombre de usuario",
                  hintText: "Nombre de usuario",
                  prefixIcon: const Icon(Icons.person),
                  fillColor: Colors.grey.shade200,
                  border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(50)),
                ),
              ),
              const SizedBox(
                height: 15,
              ),
              TextFormField(
                controller: emailController,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Por favor, introduzca email';
                  } else if (!emailRegExp.hasMatch(value)) {
                    return 'Por favor, introduzca un email válido';
                  }
                  return null;
                },
                cursorColor: Colors.black,
                keyboardType: TextInputType.emailAddress,
                decoration: InputDecoration(
                  filled: true,
                  labelText: "Email",
                  hintText: "Email",
                  prefixIcon: const Icon(Icons.email),
                  fillColor: Colors.grey.shade200,
                  border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(50)),
                ),
              ),
              const SizedBox(
                height: 15,
              ),
              TextFormField(
                controller: phoneNumberController,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Por favor, introduzca teléfono ';
                  } else if (value.length < 10) {
                    return 'Por favor, introduzca teléfono válido';
                  }
                  return null;
                },
                keyboardType: TextInputType.phone,
                cursorColor: Colors.black,
                decoration: InputDecoration(
                  filled: true,
                  labelText: "Número de teléfono",
                  hintText: "Número de teléfono",
                  prefixIcon: const Icon(Icons.phone),
                  fillColor: Colors.grey.shade200,
                  border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(50)),
                ),
              ),
              const SizedBox(
                height: 20,
              ),
              isLoading
                  ? const Center(
                      child: CircularProgressIndicator(),
                    )
                  : MaterialButton(
                      onPressed: () {
                        if (_formKey.currentState!.validate()) {
                          if (widget.user != null) {
                            print("Editar Usuario");
                            updateUser();
                          } else {
                            sendUserOnFirebase();
                          }
                        } else {}
                      },
                      color: Colors.red,
                      child: Text(
                        widget.user != null
                            ? "Editar usuario"
                            : "Añadir usuario",
                        style: const TextStyle(color: Colors.white),
                      ),
                    )
            ],
          ),
        ),
      ),
    );
  }
}