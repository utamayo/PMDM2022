import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter_07_firebase_storage/services/imagen_service.dart';
import 'package:flutter_07_firebase_storage/services/upload_images.dart';
import 'package:image_picker/image_picker.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  File? imagen_to_upload;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          elevation: 0,
          title: const Text('Firebase Storage'),
        ),
        body: Column(
          children: [
            imagen_to_upload != null
                ? Image.file(imagen_to_upload!)
                : Container(
                    height: 200,
                    width: double.infinity,
                    margin: EdgeInsets.all(10),
                    color: Colors.grey,
                  ),
            ElevatedButton(
                onPressed: () async {
                  final XFile? imagen = await getImage();
                  setState(() {
                    imagen_to_upload = File(imagen!.path);
                  });
                },
                child: const Text('Seleccionar Imagen')),
            ElevatedButton(
                onPressed: () async {
                  if (imagen_to_upload == null) {
                    return;
                  }
                  final uploaded = await uploadImage(imagen_to_upload!);

                  if (uploaded) {
                    ScaffoldMessenger.of(context).showSnackBar(const SnackBar(
                        content: Text("Imagen subida correctamente")));
                  } else {
                    ScaffoldMessenger.of(context).showSnackBar(const SnackBar(
                        content: Text("Error al subir la imagen")));
                  }
                },
                child: const Text('Subir Imagen a Firebase')),
          ],
        ));
  }
}
