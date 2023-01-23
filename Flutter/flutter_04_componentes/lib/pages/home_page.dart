import 'package:flutter/material.dart';
import 'package:flutter_04_componentes/pages/listview1_page.dart';

class Home_Page extends StatelessWidget {
  Home_Page({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text('Flutter Componentes'),
        ),
        body: ListView(
          children: [
            ListTile(
              title: const Text('Listas de tipo 1'),
              leading: const Icon(Icons.account_balance_wallet),
              trailing: const Icon(Icons.keyboard_arrow_right),
              onTap: () => Navigator.pushNamed(context, 'lista1'),
            ),
            const Divider(),
            ListTile(
              title: const Text('Listas de tipo 2'),
              leading: const Icon(Icons.account_balance_wallet),
              trailing: const Icon(Icons.keyboard_arrow_right),
              onTap: () => Navigator.pushNamed(context, 'lista2'),
            ),
            const Divider(),
            ListTile(
              title: const Text('Alerts - Alertas'),
              leading: const Icon(Icons.account_balance_wallet),
              trailing: const Icon(Icons.keyboard_arrow_right),
              onTap: () => Navigator.pushNamed(context, 'alert'),
            ),
            const Divider(),
            ListTile(
              title: const Text('Cards - Tarjetas'),
              leading: const Icon(Icons.account_balance_wallet),
              trailing: const Icon(Icons.keyboard_arrow_right),
              onTap: () => Navigator.pushNamed(context, 'card'),
            ),
            const Divider(),
            ListTile(
              title: const Text('Avatar'),
              leading: const Icon(Icons.image_rounded),
              trailing: const Icon(Icons.keyboard_arrow_right),
              onTap: () => Navigator.pushNamed(context, 'avatar'),
            ),
            const Divider(),
          ],
        ));
  }
}
