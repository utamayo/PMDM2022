import 'package:flutter/material.dart';

class AppTheme {
  static const Color primario = Colors.indigo;
  // Personalizacion del TEMA CLARO
  static final ThemeData lightTheme = ThemeData.light().copyWith(
    // Estilo de la AppBar
    appBarTheme: const AppBarTheme(
      backgroundColor: primario,
      elevation: 0,
    ),

    // Estilo de los iconos
    iconTheme: const IconThemeData(color: Colors.indigo),
  );

  // Tema Propio: HALLOWEEN
  static final ThemeData halloween = ThemeData.dark().copyWith(
      appBarTheme: const AppBarTheme(backgroundColor: Colors.orange),
      backgroundColor: Colors.black,
      iconTheme: const IconThemeData(color: Colors.orange),
      // Estilo de los botones
      textButtonTheme: TextButtonThemeData(
          style: TextButton.styleFrom(primary: Colors.orange)),
      //Estilo de los ElevatedButtons
      elevatedButtonTheme: ElevatedButtonThemeData(
        style: ElevatedButton.styleFrom(
          backgroundColor: Colors.orange,
          shape: const StadiumBorder(),
          elevation: 0,
        ),
      ));
}
