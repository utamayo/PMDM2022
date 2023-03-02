import 'package:flutter/material.dart';
import 'package:flutter_09_realtimedatabase/pages/add_new_user_page.dart';
import 'package:provider/provider.dart';
import '../model/user.dart';
import 'package:http/http.dart' as http;

import '../provider/crud_realtimedb_provider.dart';

class UserTile extends StatelessWidget {
  final User? user;
  const UserTile({super.key, this.user});

  @override
  Widget build(BuildContext context) {
    final provider = Provider.of<CRUDOperationProvider>(context);
    return Card(
      child: ListTile(
        title: Text(user!.username),
        subtitle: Text("${user!.email}, \n${user!.phoneNumber}"),
        trailing: SizedBox(
          width: MediaQuery.of(context).size.width * 0.4,
          child: Row(
            mainAxisAlignment: MainAxisAlignment.end,
            children: [
              IconButton(
                onPressed: () {
                  // Editar usuario
                  Navigator.of(context).push(MaterialPageRoute(
                      builder: (_) => AddNewUserPage(
                            user: user,
                          )));
                },
                icon: const Icon(
                  Icons.edit,
                  color: Colors.green,
                ),
              ),
              IconButton(
                onPressed: () async {
                  // Eliminar Usuario
                  provider.deleteUser(context: context, id: user!.docId);
                },
                icon: const Icon(
                  Icons.delete,
                  color: Colors.red,
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
