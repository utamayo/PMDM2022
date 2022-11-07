package org.iesch.a10_recyclerviewbasico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 9 - Debemos construir una lista que se envia como parametro al adaptdaor
    ArrayList<String> listDatos;
    // 10 - Genero una referencia l RecyclerView
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //11
        recyclerView = findViewById(R.id.recyclerId);
        //12
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        //13
        listDatos = new ArrayList<>();
        for (int i=0; i<=100; i++){
            listDatos.add("Dato # "+i+" ");
        }
        // 14 Le envío la lista como parametro al adaptador
        AdapterDatos adaptador = new AdapterDatos(listDatos);
        recyclerView.setAdapter(adaptador);

    }
}















