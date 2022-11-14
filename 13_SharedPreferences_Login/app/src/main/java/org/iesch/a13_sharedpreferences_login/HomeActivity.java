package org.iesch.a13_sharedpreferences_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnSalir=findViewById(R.id.btnLogout);

        btnSalir.setOnClickListener(v -> {
            logOut();
        });
    }

    private void logOut() {
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = preferencias.edit();

        Obj_editor.putString("email","");
        Obj_editor.putString("pass","");
        Obj_editor.commit();

        Intent i = new Intent(HomeActivity.this, MainActivity.class);
        startActivity(i);
    }
}















