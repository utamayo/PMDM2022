import 'package:flutter/material.dart';

class TarjetaPersonalizada2 extends StatelessWidget {
  const TarjetaPersonalizada2({
    Key? key,
    required this.imageUrl,
    this.comentario,
  }) : super(key: key);

  final String imageUrl;
  final String? comentario;
  @override
  Widget build(BuildContext context) {
    return Card(
      clipBehavior: Clip.antiAlias,
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(18)),
      //shadowColor: Colors.orange,
      elevation: 10,
      child: Column(
        children: [
          FadeInImage(
            image: NetworkImage(imageUrl),
            placeholder: const AssetImage('assets/jar-loading.gif'),
            fadeInDuration: const Duration(milliseconds: 300),
            height: 250.0,
            fit: BoxFit.cover,
          ),
          if (comentario != null)
            Container(
              alignment: AlignmentDirectional.centerEnd,
              padding: const EdgeInsets.all(10.0),
              child: Text(comentario!),
            )
        ],
      ),
    );
  }
}
