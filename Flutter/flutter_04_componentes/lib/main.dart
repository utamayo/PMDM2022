import 'package:flutter/material.dart';
import 'package:flutter_04_componentes/pages/pages.dart';
import 'package:flutter_04_componentes/theme/app_theme.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Material App',
      initialRoute: 'home',
      routes: {
        'home': (context) => Home_Page(),
        'lista1': (context) => ListView1_Page(),
        'lista2': (context) => ListView2_Page(),
        'alert': (context) => Alert_Page(),
        'card': (context) => Card_Page(),
        'avatar': (context) => AvatarPage(),
        'formulario': (context) => FormularioPage(),
        'slider': (context) => SliderPage(),
      },
      theme: AppTheme.lightTheme,
    );
  }
}
