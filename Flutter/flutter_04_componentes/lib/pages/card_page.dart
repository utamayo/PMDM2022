import 'package:flutter/material.dart';

import '../widgets/tarjeta_personalizada_1.dart';
import '../widgets/tarjeta_personalizada_2.dart';

class Card_Page extends StatelessWidget {
  Card_Page({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text('Cards - Tarjetas'),
          elevation: 0,
        ),
        body: ListView(
          padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 10),
          children: const [
            TarjetaPersonalizada1(),
            SizedBox(
              height: 10,
            ),
            TarjetaPersonalizada2(
              imageUrl:
                  'https://images.pexels.com/photos/2662116/pexels-photo-2662116.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1',
              comentario: 'Esto es un bonito paisaje',
            ),
            SizedBox(
              height: 10,
            ),
            TarjetaPersonalizada2(
              imageUrl:
                  'https://images.pexels.com/photos/1287145/pexels-photo-1287145.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1',
              comentario: 'Esto es un bonito paisaje',
            ),
            SizedBox(
              height: 10,
            ),
            TarjetaPersonalizada2(
              imageUrl:
                  'https://images.pexels.com/photos/5366526/pexels-photo-5366526.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1',
            ),
            SizedBox(
              height: 10,
            ),
            TarjetaPersonalizada2(
              imageUrl:
                  'https://images.pexels.com/photos/2325446/pexels-photo-2325446.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1',
            ),
          ],
        ));
  }
}
