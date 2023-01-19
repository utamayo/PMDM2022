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
    iconTheme: const IconThemeData(opacity: 0.1, color: primario),
  );

  // Tema Propio: HALLOWEEN
  static final ThemeData halloween = ThemeData.dark().copyWith(
      appBarTheme: const AppBarTheme(backgroundColor: Colors.orange),
      backgroundColor: Colors.black,
      iconTheme: const IconThemeData(color: Colors.orange),
      // Estilo de los botones
      textButtonTheme: TextButtonThemeData(
          style: TextButton.styleFrom(primary: Colors.orange)));
}
