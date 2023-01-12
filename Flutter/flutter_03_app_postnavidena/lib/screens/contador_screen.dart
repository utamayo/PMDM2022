import 'package:flutter/material.dart';

class ContadorScreen extends StatefulWidget {
  const ContadorScreen({super.key});

  @override
  State<ContadorScreen> createState() => _ContadorScreenState();
}

class _ContadorScreenState extends State<ContadorScreen> {
  // variables o propiedades
  int contador = 9;
  @override
  Widget build(BuildContext context) {
    const fontsize30 = TextStyle(fontSize: 30);

    return Scaffold(
      appBar: AppBar(
        title: const Text('Contador Screen'),
        centerTitle: true,
        elevation: 0,
      ),
      //backgroundColor: Colors.red,
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Text('Número de clics:', style: fontsize30),
            Text('$contador', style: fontsize30),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        child: const Icon(Icons.add),
        onPressed: () {
          contador++;
          setState(() {});
        },
      ),
      //floatingActionButtonLocation: FloatingActionButtonLocation.startTop,
    );
  }
}
