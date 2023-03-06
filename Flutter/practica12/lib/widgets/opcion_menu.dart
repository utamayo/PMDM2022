import 'package:flutter/material.dart';

class OpcionMenu extends StatelessWidget {
  final Color color;
  final IconData icono;
  final String titulo;
  final String? ruta;
  const OpcionMenu({
    super.key,
    required this.color,
    required this.icono,
    required this.titulo,
    this.ruta,
  });

  @override
  Widget build(BuildContext context) {
    return InkWell(
      onTap: () {
        //Navegar donde queramos
      },
      child: Container(
        decoration: BoxDecoration(
          borderRadius: BorderRadius.circular(20),
          color: color,
        ),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(
              icono,
              size: 50,
              color: Colors.white,
            ),
            Text(
              titulo,
              style: const TextStyle(color: Colors.white, fontSize: 20),
            )
          ],
        ),
      ),
    );
  }
}
