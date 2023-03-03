import 'package:flutter/material.dart';
import 'package:practica12/widgets/opcion_menu.dart';

class MenuScreen extends StatelessWidget {
  const MenuScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        padding: const EdgeInsets.all(8.0),
        child: GridView(
          gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
              crossAxisCount: 2, mainAxisSpacing: 10, crossAxisSpacing: 10),
          children: const [
            OpcionMenu(
              color: Colors.red,
              icono: Icons.web,
              titulo: '11 - API REST',
            ),
            OpcionMenu(
                color: Colors.lime,
                icono: Icons.disc_full,
                titulo: '12 - FIRESTORAGE'),
          ],
        ),
      ),
    );
  }
}
