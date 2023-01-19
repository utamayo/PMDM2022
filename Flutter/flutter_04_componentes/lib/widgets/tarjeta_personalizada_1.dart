import 'package:flutter/material.dart';

class TarjetaPersonalizada1 extends StatelessWidget {
  const TarjetaPersonalizada1({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Card(
      child: Column(
        children: [
          const ListTile(
            leading: Icon(Icons.photo_album_outlined),
            title: Text('Soy un titulo'),
            subtitle: Text(
                'Officia ex sint consectetur do mollit.Ad irure amet aliquip laboris ipsum esse excepteur nostrud Lorem quis anim ex. Esse non magna quis aute consequat sunt laboris laborum laboris. Ad anim id irure nisi. Enim do non reprehenderit eiusmod. Et non et reprehenderit ullamco adipisicing eu non deserunt. Consectetur ea tempor enim sunt nostrud.'),
          ),
          Padding(
            padding: const EdgeInsets.only(right: 5),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.end,
              children: [
                TextButton(
                  onPressed: () {},
                  child: const Text('Ok'),
                ),
                TextButton(
                  onPressed: () {},
                  child: const Text('Cancelar'),
                ),
              ],
            ),
          )
        ],
      ),
    );
  }
}
