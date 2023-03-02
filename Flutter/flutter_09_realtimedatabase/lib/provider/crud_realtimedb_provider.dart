import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

import '../model/user.dart';

class CRUDOperationProvider extends ChangeNotifier {
  CRUDOperationProvider() {
    fetchUsers();
  }

  late List<User?> listaUsuarios;
  final formKey = GlobalKey<FormState>();
  final emailRegExp = RegExp(
    r"^[a-zA-Z0-9.a-zA-Z0-9.!#$%&'*+-/=?^_`{|}~]+@[a-zA-Z0-9]+\.[a-zA-Z]+",
  );
  TextEditingController usernameController = TextEditingController();
  TextEditingController emailController = TextEditingController();
  TextEditingController phoneNumberController = TextEditingController();
  bool isLoading = false;
  // FUNCION PARA AÑADIR USUARIOS
  sendUserOnFirebase(BuildContext context) async {
    isLoading = true;
    notifyListeners();

    final response = await http.post(
      Uri.parse(
          'https://fir-flutterdam23-default-rtdb.europe-west1.firebasedatabase.app/usuarios.json'),
      body: jsonEncode({
        "username": usernameController.text,
        "email": emailController.text,
        "phoneNumber": phoneNumberController.text,
      }),
    );

    if (response.statusCode == 200) {
      usernameController = TextEditingController();
      emailController = TextEditingController();
      phoneNumberController = TextEditingController();
      ScaffoldMessenger.of(context).showSnackBar(const SnackBar(
        content: Text(
          'Usuario añadido correctamente',
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

    isLoading = false;
    notifyListeners();
  }

  //FUNCION PARA ACTUALIZAR USUARIOS
  updateUser({required BuildContext context, required String id}) async {
    final response = await http.patch(
        Uri.parse(
            'https://fir-flutterdam23-default-rtdb.europe-west1.firebasedatabase.app/usuarios/$id.json'),
        body: jsonEncode({
          "username": usernameController.text,
          "email": emailController.text,
          "phoneNumber": phoneNumberController.text,
        }));
    if (response.statusCode == 200) {
      usernameController = TextEditingController();
      emailController = TextEditingController();
      phoneNumberController = TextEditingController();
      ScaffoldMessenger.of(context).showSnackBar(const SnackBar(
        content: Text(
          'Usuario actualizado correctamente',
        ),
        backgroundColor: Colors.green,
      ));
    } else {
      ScaffoldMessenger.of(context).showSnackBar(const SnackBar(
        content: Text(
          'Error al actualizar el usuario',
        ),
        backgroundColor: Colors.red,
      ));
    }
    fetchUsers();
  }

  //FUNCION PARA OBTENER LOS USUARIOS
  fetchUsers() async {
    listaUsuarios = [];
    final response = await http.get(Uri.parse(
        'https://fir-flutterdam23-default-rtdb.europe-west1.firebasedatabase.app/usuarios.json'));
    final extractedData = jsonDecode(response.body) as Map<String, dynamic>;
    extractedData.forEach((key, value) {
      listaUsuarios.add(User(
          username: value["username"],
          email: value["email"],
          phoneNumber: value["phoneNumber"],
          docId: key));
    });
    notifyListeners();
  }

  // FUNCION PARA ELIMINAR UN CONTACTO
  deleteUser({required BuildContext context, required String id}) async {
    final response = await http.delete(Uri.parse(
        'https://fir-flutterdam23-default-rtdb.europe-west1.firebasedatabase.app/usuarios/$id.json'));
    if (response.statusCode == 200) {
      ScaffoldMessenger.of(context).showSnackBar(const SnackBar(
        content: Text(
          'Usuario eliminado correctamente',
        ),
        backgroundColor: Colors.green,
      ));
    } else {
      ScaffoldMessenger.of(context).showSnackBar(const SnackBar(
        content: Text(
          'Error al eliminar usuario',
        ),
        backgroundColor: Colors.red,
      ));
    }
    fetchUsers();
  }
}
