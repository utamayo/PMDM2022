import 'package:flutter/material.dart';

class AuthButton extends StatelessWidget {
  final IconData iconData;
  final String titulo;
  final Function()? onTap;
  const AuthButton({
    super.key,
    required this.iconData,
    required this.titulo,
    this.onTap,
  });

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.only(top: 10),
      child: InkWell(
        onTap: onTap,
        child: Container(
          height: 40,
          decoration: BoxDecoration(
              border: Border.all(color: Colors.grey),
              borderRadius: BorderRadius.circular(20)),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Icon(iconData),
              Text(titulo),
            ],
          ),
        ),
      ),
    );
  }
}
