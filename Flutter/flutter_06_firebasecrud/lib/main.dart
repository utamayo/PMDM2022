import 'package:flutter/material.dart';
import 'package:flutter_06_firebasecrud/pages/cesta_compra_page.dart';
// 1 - Añadimos nuestras importaciones para nuestro proyecto con Firebase
import 'firebase_options.dart';
import 'package:firebase_core/firebase_core.dart';

void main() async {
  // 1 - Integramos nuestro proyecto con Firebase
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp(
    options: DefaultFirebaseOptions.currentPlatform,
  );
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Material App',
      home: CestaCompraPage(),
    );
  }
}
