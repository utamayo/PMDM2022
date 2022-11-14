package org.iesch.a13_sharedpreferences_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText editTextEmail, editTexPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnEntrar);
        editTextEmail = findViewById(R.id.editTextEmailAddress);
        editTexPassword = findViewById(R.id.editTextPassword);

        // 1 - Al iniciar la Aplicacion debe mostrar lo que tiene GUARDADO en el archivo SharedPrefrences
        //Obtengo los valores que se han creado previamente
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);

        if (preferencias.getString("email","") != ""){
            Intent i = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(i);
        }
        // 2 - Escribimos las referencias que hemos obtenido en el valor que buscamos
        // El par de comillas vacío es el valor inicial EN CASO DE QUE NO HAYA NINGÚN VALOR
        editTextEmail.setText(preferencias.getString("email",""));
        editTexPassword.setText(preferencias.getString("pass",""));

        btnLogin.setOnClickListener(v -> {
          guardar();
          Toast.makeText(this, "Se ha guardado correctamente", Toast.LENGTH_SHORT).show();

        });
    }

    private void guardar() {
        // En este método he de crear el objeto nuevamente
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        // Editor esla clase que me sirve para modificar este archivo
        SharedPreferences.Editor Obj_editor = preferences.edit();

        Obj_editor.putString("email", editTextEmail.getText().toString());
        Obj_editor.putString("pass", editTexPassword.getText().toString());
        //Commit confirma que lo que acabamoos de recuperar arriba lo queremos GUARDAR.
        // Sin commit no guarda nada en SharedPreferences
        Obj_editor.commit();

    }
}
























