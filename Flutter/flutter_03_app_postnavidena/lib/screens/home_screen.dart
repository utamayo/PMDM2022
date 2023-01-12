import 'package:flutter/material.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Home Screen'),
        centerTitle: true,
        elevation: 0,
      ),
      //backgroundColor: Colors.red,
      body: const Center(
        child: Text('Hola DAM2'),
      ),
    );
  }
}
