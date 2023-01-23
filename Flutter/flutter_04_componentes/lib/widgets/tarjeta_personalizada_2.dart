import 'package:flutter/material.dart';

class TarjetaPersonalizada2 extends StatelessWidget {
  const TarjetaPersonalizada2({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Card(
      clipBehavior: Clip.antiAlias,
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(18)),
      //shadowColor: Colors.orange,
      elevation: 10,
      child: Column(
        children: [
          const FadeInImage(
            image: NetworkImage(
                'https://images.pexels.com/photos/2662116/pexels-photo-2662116.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
            placeholder: AssetImage('assets/jar-loading.gif'),
            fadeInDuration: Duration(milliseconds: 300),
            height: 250.0,
            fit: BoxFit.cover,
          ),
          Container(
            alignment: AlignmentDirectional.centerEnd,
            padding: const EdgeInsets.all(10.0),
            child: const Text('No tengo ni idea de qué poner'),
          )
        ],
      ),
    );
  }
}
