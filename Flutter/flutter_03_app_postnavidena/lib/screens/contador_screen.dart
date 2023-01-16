import 'package:flutter/material.dart';

class ContadorScreen extends StatefulWidget {
  const ContadorScreen({super.key});

  @override
  State<ContadorScreen> createState() => _ContadorScreenState();
}

class _ContadorScreenState extends State<ContadorScreen> {
  int contador = 10;

  void incrementar() {
    contador++;
    setState(() {});
    print(contador);
  }

  void decrementar() {
    contador--;
    setState(() {});
  }

  void resetear() {
    contador = 0;
    setState(() {});
  }

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
      floatingActionButtonLocation: FloatingActionButtonLocation.centerFloat,
      floatingActionButton: BotoneraPersonalizada(
        incrementarFn: incrementar,
        decrementarFn: decrementar,
        resetearFn: resetear,
      ),
    );
  }
}

class BotoneraPersonalizada extends StatelessWidget {
  final Function incrementarFn;
  final Function decrementarFn;
  final Function resetearFn;

  const BotoneraPersonalizada({
    Key? key,
    required this.incrementarFn,
    required this.decrementarFn,
    required this.resetearFn,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
      children: [
        FloatingActionButton(
          child: const Icon(Icons.exposure_minus_1_outlined),
          onPressed: () => decrementarFn,
        ),
        FloatingActionButton(
          child: const Icon(Icons.exposure_outlined),
          onPressed: () => resetearFn,
        ),
        FloatingActionButton(
          child: const Icon(Icons.add),
          onPressed: () {
            print('Llamo a incrementar');
            incrementarFn;
          },
        ),
      ],
    );
  }
}
