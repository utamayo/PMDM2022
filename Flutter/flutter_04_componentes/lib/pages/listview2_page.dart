import 'package:flutter/material.dart';

class ListView2_Page extends StatelessWidget {
  ListView2_Page({super.key});

  final opciones = [
    'Batman',
    'Superman',
    'Super agente Loras',
    'Spiderman',
    'La Xavineta',
    'Batman',
    'Superman',
    'Super agente Loras',
    'Spiderman',
    'La Xavineta',
    'Batman',
    'Superman',
    'Super agente Loras',
    'Spiderman',
    'La Xavineta',
    'Batman',
    'Superman',
    'Super agente Loras',
    'Spiderman',
    'La Xavineta',
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          //backgroundColor: Colors.indigo,
          title: const Text('Tipo Lista 2 Page'),
          //elevation: 0,
        ),
        body: ListView.separated(
          itemCount: opciones.length,
          itemBuilder: ((context, i) {
            return ListTile(
              leading: const Icon(
                Icons.child_care,
                color: Colors.indigo,
              ),
              title: Text(opciones[i]),
              subtitle: Text(opciones[i]),
              trailing: const Icon(
                Icons.arrow_forward_ios_outlined,
                color: Colors.indigo,
              ),
              onTap: () {
                final superheroe = opciones[i];
                print(superheroe);
              },
            );
          }),
          separatorBuilder: ((_, __) => const Divider()),
        ));
  }
}
