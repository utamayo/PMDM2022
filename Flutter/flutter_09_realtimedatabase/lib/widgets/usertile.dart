import 'package:flutter/material.dart';

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
      ),
    );
  }
}
