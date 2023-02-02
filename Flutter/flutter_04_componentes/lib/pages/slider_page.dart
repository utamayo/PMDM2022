import 'package:flutter/material.dart';

class SliderPage extends StatefulWidget {
  const SliderPage({super.key});

  @override
  State<SliderPage> createState() => _SliderPageState();
}

class _SliderPageState extends State<SliderPage> {
  double _sliderValor = 100;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Slider Page')),
      body: Column(
        children: [
          Slider.adaptive(
              activeColor: Colors.indigo,
              //divisions: 10,
              min: 50,
              max: 400,
              value: _sliderValor,
              onChanged: ((value) {
                _sliderValor = value;
                setState(() {});
              })),
          Expanded(
            child: SingleChildScrollView(
              child: Image(
                fit: BoxFit.contain,
                width: _sliderValor,
                image: const NetworkImage(
                  'https://cdn.pixabay.com/photo/2020/07/06/17/51/batman-5377804_1280.png',
                ),
              ),
            ),
          ),
          const SizedBox(
            height: 20,
          )
        ],
      ),
    );
  }
}
