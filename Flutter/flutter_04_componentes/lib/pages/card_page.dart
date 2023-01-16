import 'package:flutter/material.dart';

class Card_Page extends StatelessWidget {
  Card_Page({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text('Card Page'),
          elevation: 0,
        ),
        body: Center(child: Text('Card Page')));
  }
}
