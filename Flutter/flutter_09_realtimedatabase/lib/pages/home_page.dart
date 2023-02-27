import 'package:flutter/material.dart';
import 'package:flutter_09_realtimedatabase/model/user.dart';

import 'add_new_user_page.dart';

class MenuPage extends StatefulWidget {
  const MenuPage({super.key});

  @override
  State<MenuPage> createState() => _MenuPageState();
}

class _MenuPageState extends State<MenuPage> {
  List<User> _list = [];
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Real Time Data Base'),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          Navigator.of(context).push(
            MaterialPageRoute(builder: (_) => const AddNewUserPage()),
          );
        },
        child: const Icon(Icons.add),
      ),
      body: ListView.builder(itemBuilder: (context, index){
        return UserTile(user: )
      }),
    );
  }
}
