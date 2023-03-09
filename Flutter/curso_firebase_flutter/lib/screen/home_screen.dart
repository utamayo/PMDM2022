import 'package:curso_firebase_flutter/provider/auth_provider.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  @override
  void didChangeDependencies() {
    final authProvider = Provider.of<AuthProvider>(context, listen: false);
    authProvider.updateEmailVerificationState();

    super.didChangeDependencies();
  }

  @override
  Widget build(BuildContext context) {
    return Consumer<AuthProvider>(builder: (context, model, _) {
      return Scaffold(
        appBar: AppBar(actions: [
          IconButton(
              onPressed: () {
                model.logOut();
              },
              icon: const Icon(Icons.logout))
        ]),
        body: Center(
            child: model.emailVerificado == false
                ? const Text('Email no está verificado')
                : const Text('Email verificado!!')),
      );
    });
  }
}
