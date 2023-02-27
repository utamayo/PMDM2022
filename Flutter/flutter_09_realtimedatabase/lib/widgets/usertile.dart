import 'package:flutter/material.dart';
import 'package:flutter_09_realtimedatabase/pages/add_new_user_page.dart';
import '../model/user.dart';

class UserTile extends StatelessWidget {
  final User user;
  const UserTile({super.key, required this.user});

  @override
  Widget build(BuildContext context) {
    return Card(
      child: ListTile(
        title: Text(user.username),
        subtitle: Text("${user.email}, \n${user.phoneNumber}"),
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
                onPressed: () {
                  // Eliminar Usuario
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
