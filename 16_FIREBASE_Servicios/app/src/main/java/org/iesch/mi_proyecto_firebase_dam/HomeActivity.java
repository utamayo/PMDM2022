package org.iesch.mi_proyecto_firebase_dam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    TextView tvEmail, tvMetodo;
    Button logOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Home Firebase");
        tvEmail=findViewById(R.id.emailTextView);
        tvMetodo=findViewById(R.id.metodoTextView);
        logOutButton=findViewById(R.id.logoutButton);

        obtenerInfodeLogin();
        eventosBoton();
    }

    private void eventosBoton() {
        logOutButton.setOnClickListener(v -> {
            cerrarSesion();
        });
    }

    private void cerrarSesion() {
        SharedPreferences sesion = getSharedPreferences("sesion", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_Editor = sesion.edit();
        Obj_Editor.clear();
        Obj_Editor.apply();


        //Cerramos la sesion en Firebase
        FirebaseAuth.getInstance().signOut();
        onBackPressed();
    }

    private void obtenerInfodeLogin() {
        // Recuperamos la informacion de LoginActivity
        Bundle datos = this.getIntent().getExtras();
        String email = datos.getString("email");
        String metodo = datos.getString("metodo");
        tvEmail.setText(email);
        tvMetodo.setText(metodo);
        //Guardo los datos al llegar a Home
        SharedPreferences sesion = getSharedPreferences("sesion", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_Editor = sesion.edit();
        Obj_Editor.putString("email",email);
        Obj_Editor.putString("metodo",metodo);
        Obj_Editor.apply();
        //Obj_Editor.commit();
    }
}









