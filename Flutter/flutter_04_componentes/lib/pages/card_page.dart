import 'package:flutter/material.dart';

import '../widgets/tarjeta_personalizada_1.dart';

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
            TarjetaPersonalizada1(),
            TarjetaPersonalizada1(),
            TarjetaPersonalizada1(),
            TarjetaPersonalizada1(),
            TarjetaPersonalizada1(),
          ],
        ));
  }
}
