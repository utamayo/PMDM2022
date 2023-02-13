import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import 'package:flutter_06_firebasecrud/model/producto.dart';

class CestaCompraPage extends StatefulWidget {
  const CestaCompraPage({super.key});

  @override
  State<CestaCompraPage> createState() => _CestaCompraPageState();
}

class _CestaCompraPageState extends State<CestaCompraPage> {
  List<Producto> listaProductos = [];

  @override
  void initState() {
    super.initState();
    FirebaseFirestore.instance.collection('cesta_compra').snapshots().listen(
      (productos) {
        mapProductos(productos);
      },
    );
    fetchProductos();
  }

  // Consultamos los registros de la coleccion de Firebase Firestorage
  void fetchProductos() async {
    var lista_productos =
        await FirebaseFirestore.instance.collection('cesta_compra').get();
    mapProductos(lista_productos);
  }

  void mapProductos(QuerySnapshot<Map<String, dynamic>> lista_productos) {
    // Me creo un producto por cada producto quw tenga en la coleccion
    var _list = lista_productos.docs
        .map((producto) => Producto(
              id: producto.id,
              descripcion: producto['descripcion'],
              cantidad: producto['cantidad'] ?? '',
            ))
        .toList();
    setState(() {
      listaProductos = _list;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Cesta Compra'),
        elevation: 0,
        actions: [IconButton(onPressed: () {}, icon: Icon(Icons.add))],
      ),
      body: ListView.builder(
          itemCount: listaProductos.length,
          itemBuilder: (context, index) {
            return ListTile(
              title: Text(listaProductos[index].descripcion),
              subtitle: Text(listaProductos[index].cantidad ?? ''),
            );
          }),
    );
  }
}
