import 'package:flutter/material.dart';

class CustomInputWidget extends StatelessWidget {
  final String? hintText;
  final String? labelText;
  final String? helperText;
  final IconData? icon;
  final IconData? suffixIcon;
  final TextInputType? teclado;
  final bool obscureText;

  // He de recibir dos cosas:
  final String formProperty;
  final Map<String, String> formValues;

  const CustomInputWidget({
    Key? key,
    this.hintText,
    this.labelText,
    this.helperText,
    this.icon,
    this.suffixIcon,
    this.teclado,
    this.obscureText = false,
    required this.formProperty,
    required this.formValues,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return TextFormField(
      onChanged: (value) => formValues[formProperty] = value,
      keyboardType: teclado,
      obscureText: obscureText,
      autofocus: false,
      initialValue: '',
      textCapitalization: TextCapitalization.words,
      decoration: InputDecoration(
        labelText: labelText,
        hintText: hintText,
        helperText: helperText,
        suffixIcon: suffixIcon == null ? null : Icon(suffixIcon),
        // prefixIcon: Icon(Icons.verified_user_outlined),
        icon: icon == null ? null : Icon(icon),
      ),
      //onChanged: (valor) {
      //  print(valor);
      //},
      validator: (value) {
        if (value == null) return 'Este campo es requerido';
        return value.length < 3 ? 'Minimo 3 caracteres' : null;
      },
      autovalidateMode: AutovalidateMode.onUserInteraction,
    );
  }
}
