import 'package:flutter/material.dart';

class Alert_Page extends StatelessWidget {
  Alert_Page({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text('Alert Page'),
          elevation: 0,
        ),
        body: Center(child: Text('Alert Page')));
  }
}
