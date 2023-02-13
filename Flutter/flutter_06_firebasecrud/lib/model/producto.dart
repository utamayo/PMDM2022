// To parse this JSON data, do
//
//     final producto = productoFromJson(jsonString);

import 'dart:convert';

Producto productoFromJson(String str) => Producto.fromJson(json.decode(str));

String productoToJson(Producto data) => json.encode(data.toJson());

class Producto {
  Producto({
    required this.id,
    required this.descripcion,
    this.cantidad,
  });

  String id;
  String descripcion;
  String? cantidad;

  factory Producto.fromJson(Map<String, dynamic> json) => Producto(
        id: json["id"],
        descripcion: json["descripcion"],
        cantidad: json["cantidad"] ?? '',
      );

  Map<String, dynamic> toJson() => {
        "id": id,
        "descripcion": descripcion,
        "cantidad": cantidad,
      };
}
