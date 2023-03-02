import 'package:flutter/material.dart';
import 'package:flutter_09_realtimedatabase/pages/add_new_user_page.dart';
import '../model/user.dart';
import 'package:http/http.dart' as http;

class UserTile extends StatelessWidget {
  final User? user;
  const UserTile({super.key, this.user});

  @override
  Widget build(BuildContext context) {
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
                  final response = await http.delete(Uri.parse(
                      'https://fir-flutterdam23-default-rtdb.europe-west1.firebasedatabase.app/usuarios/${user!.docId}.json'));
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
