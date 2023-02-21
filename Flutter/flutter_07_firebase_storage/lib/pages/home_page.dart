import 'package:flutter/material.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          elevation: 0,
          title: const Text('Firebase Storage'),
        ),
        body: Column(
          children: [
            Container(
              height: 200,
              width: double.infinity,
              margin: EdgeInsets.all(10),
              color: Colors.grey,
            ),
            ElevatedButton(
                onPressed: () {}, child: const Text('Seleccionar Imagen')),
            ElevatedButton(
                onPressed: () {}, child: const Text('Subir Imagen a Firebase')),
          ],
        ));
  }
}
