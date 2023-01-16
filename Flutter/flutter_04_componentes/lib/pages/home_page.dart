import 'package:flutter/material.dart';
import 'package:flutter_04_componentes/pages/listview1_page.dart';

class Home_Page extends StatelessWidget {
  Home_Page({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.indigo,
        title: const Text('Home Page'),
        elevation: 0,
      ),
      body: ListView.separated(
          itemBuilder: ((context, i) => ListTile(
                title: Text('Hola DAM'),
                onTap: () {
                  // Aqui vamos a navegar a otra pagina
                  //final ruta =
                  //    MaterialPageRoute(builder: (context) => ListView1_Page());
                  //Navigator.pushAndRemoveUntil(context, ruta);

                  Navigator.pushNamed(context, 'lista1');
                },
              )),
          separatorBuilder: (_, __) => const Divider(),
          itemCount: 10),
    );
  }
}
