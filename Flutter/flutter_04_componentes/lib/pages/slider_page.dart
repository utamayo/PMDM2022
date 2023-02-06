import 'package:flutter/material.dart';

class SliderPage extends StatefulWidget {
  const SliderPage({super.key});

  @override
  State<SliderPage> createState() => _SliderPageState();
}

class _SliderPageState extends State<SliderPage> {
  double _sliderValor = 100;
  bool _isChecked = false;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Slider Page')),
      body: Column(
        children: [
          SliderPersonal(),
          // Checkbox(
          //   value: _isChecked,
          //   onChanged: ((value) {
          //     setState(() {
          //       _isChecked = value!;
          //     });
          //   }),
          // ),
          // CheckboxListTile(
          //   title: Text('Bloquear Slider'),
          //   //checkColor: Colors.indigo,
          //   //tileColor: Colors.indigo[100],
          //   value: _isChecked,
          //   onChanged: ((value) {
          //     setState(() {
          //       _isChecked = value!;
          //     });
          //   }),
          // ),
          // Switch.adaptive(
          //   value: _isChecked,
          //   onChanged: ((value) {
          //     setState(() {
          //       _isChecked = value!;
          //     });
          //   }),
          // ),
          SwitchListTile.adaptive(
            //hoverColor: Colors.indigo,
            //activeTrackColor: Colors.indigo,
            title: Text('Bloquear Slider'),
            //checkColor: Colors.indigo,
            //tileColor: Colors.indigo[100],
            value: _isChecked,
            onChanged: ((value) {
              setState(() {
                _isChecked = value!;
              });
            }),
          ),
          BatmanCambiante(),
          const SizedBox(
            height: 20,
          )
        ],
      ),
    );
  }

  Widget SliderPersonal() {
    return Slider.adaptive(
        activeColor: Colors.indigo,
        //divisions: 10,
        min: 50,
        max: 400,
        value: _sliderValor,
        onChanged: (_isChecked)
            ? null
            : ((value) {
                _sliderValor = value;
                setState(() {});
              }));
  }

  Widget BatmanCambiante() {
    return Expanded(
      child: SingleChildScrollView(
        child: Image(
          fit: BoxFit.contain,
          width: _sliderValor,
          image: const NetworkImage(
            'https://cdn.pixabay.com/photo/2020/07/06/17/51/batman-5377804_1280.png',
          ),
        ),
      ),
    );
  }
}
