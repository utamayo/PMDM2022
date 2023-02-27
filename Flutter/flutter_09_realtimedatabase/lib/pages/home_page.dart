import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter_09_realtimedatabase/model/user.dart';
import 'package:flutter_09_realtimedatabase/widgets/usertile.dart';
import 'package:http/http.dart' as http;

import 'add_new_user_page.dart';

class MenuPage extends StatefulWidget {
  const MenuPage({super.key});

  @override
  State<MenuPage> createState() => _MenuPageState();
}

class _MenuPageState extends State<MenuPage> {
  List<User?> _list = [];
  //Obtenermos los usuarios de RealTime
  fetchUsers() async {
    final response = await http.get(Uri.parse(
        'https://fir-flutterdam23-default-rtdb.europe-west1.firebasedatabase.app/usuarios.json'));
    final extractedData = jsonDecode(response.body) as Map<String, dynamic>;
    extractedData.forEach((key, value) {
      _list.add(User(
          username: value["username"],
          email: value["email"],
          phoneNumber: value["phoneNumber"],
          docId: key));
    });
    //print(_list);
  }

  @override
  void didChangeDependencies() {
    fetchUsers();
    super.didChangeDependencies();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Real Time Data Base'),
        elevation: 0,
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          Navigator.of(context).push(
            MaterialPageRoute(builder: (_) => const AddNewUserPage()),
          );
        },
        child: const Icon(Icons.add),
      ),
      body: ListView.builder(
        itemBuilder: (context, index) {
          return UserTile(user: _list[index]);
        },
        itemCount: _list.length,
      ),
    );
  }
}
