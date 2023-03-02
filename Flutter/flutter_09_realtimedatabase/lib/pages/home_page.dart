import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter_09_realtimedatabase/model/user.dart';
import 'package:flutter_09_realtimedatabase/widgets/usertile.dart';
import 'package:http/http.dart' as http;
import 'package:provider/provider.dart';

import '../provider/crud_realtimedb_provider.dart';
import 'add_new_user_page.dart';

class MenuPage extends StatefulWidget {
  const MenuPage({super.key});

  @override
  State<MenuPage> createState() => _MenuPageState();
}

class _MenuPageState extends State<MenuPage> {
  @override
  Widget build(BuildContext context) {
    final provider = Provider.of<CRUDOperationProvider>(context);
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
      body: RefreshIndicator(
        onRefresh: () => provider.fetchUsers(),
        child: Padding(
          padding: EdgeInsets.all(8.0),
          child: ListView.builder(
            itemBuilder: (context, index) {
              return UserTile(user: provider.listaUsuarios[index]);
            },
            itemCount: provider.listaUsuarios.length,
          ),
        ),
      ),
    );
  }
}
