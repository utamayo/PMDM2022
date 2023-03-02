import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter_09_realtimedatabase/provider/crud_realtimedb_provider.dart';
import 'package:http/http.dart' as http;
import 'package:provider/provider.dart';
import '../model/user.dart';

class AddNewUserPage extends StatefulWidget {
  final User? user;
  const AddNewUserPage({super.key, this.user});

  @override
  State<AddNewUserPage> createState() => _AddNewUserPageState();
}

class _AddNewUserPageState extends State<AddNewUserPage> {
  @override
  Widget build(BuildContext context) {
    final provider = Provider.of<CRUDOperationProvider>(context);
    if (widget.user != null) {
      provider.usernameController =
          TextEditingController(text: widget.user!.username);
      provider.emailController =
          TextEditingController(text: widget.user!.email);
      provider.phoneNumberController =
          TextEditingController(text: widget.user!.phoneNumber);
    }
    return Scaffold(
      appBar: AppBar(
        title: const Text('Añadir Nuevo Usuario'),
        elevation: 0,
      ),
      body: Form(
        key: provider.formKey,
        child: Padding(
          padding: const EdgeInsets.all(15.0),
          child: Column(
            children: [
              TextFormField(
                controller: provider.usernameController,
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
                controller: provider.emailController,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Por favor, introduzca email';
                  } else if (!provider.emailRegExp.hasMatch(value)) {
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
                controller: provider.phoneNumberController,
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
              provider.isLoading
                  ? const Center(
                      child: CircularProgressIndicator(),
                    )
                  : MaterialButton(
                      onPressed: () {
                        if (provider.formKey.currentState!.validate()) {
                          if (widget.user != null) {
                            print("Editar Usuario");
                            provider.updateUser(
                                context: context, id: widget.user!.docId);
                          } else {
                            provider.sendUserOnFirebase(context);
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
