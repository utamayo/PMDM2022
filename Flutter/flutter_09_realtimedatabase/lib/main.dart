import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:flutter_09_realtimedatabase/pages/home_page.dart';
import 'package:flutter_09_realtimedatabase/provider/crud_realtimedb_provider.dart';
import 'package:provider/provider.dart';

import 'firebase_options.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp(
    options: DefaultFirebaseOptions.currentPlatform,
  );
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MultiProvider(
      providers: [
        ChangeNotifierProvider(create: (_) => CRUDOperationProvider()),
      ],
      child: MaterialApp(
        title: 'Material App',
        home: MenuPage(),
        theme: ThemeData(primarySwatch: Colors.red),
      ),
    );
  }
}
