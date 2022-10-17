package org.iesch.a07_lista_simple_personalizada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 9 - Me declaro el ListView y el Adaptador
    private ListView lvPeliculas;
    private Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 10 - Lo enlazo
        lvPeliculas = findViewById(R.id.lvLista);
        adaptador = new Adaptador(obtenerListaPeliculas(), this);
        // 12 - Asignamos el adaptador al listView
        lvPeliculas.setAdapter(adaptador);


    }
    // 11 - Me creo un metodopara obtener la lista de peliculas
    private ArrayList<Pelicula> obtenerListaPeliculas(){
        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

        listaPeliculas.add(new Pelicula(R.drawable.fiestasalchicha,"LA FIESTA DE LA SALCHICHA","2016"));
        listaPeliculas.add(new Pelicula(R.drawable.hoteltransilvania,"HOTEL TRANSILVANIA","2018"));
        listaPeliculas.add(new Pelicula(R.drawable.jurassicpark,"JURASSIC PARK","1992"));
        listaPeliculas.add(new Pelicula(R.drawable.regeresoalfuturo,"REGRESO AL FUTURO","1988"));
        listaPeliculas.add(new Pelicula(R.drawable.shrek,"SHREK","2015"));
        listaPeliculas.add(new Pelicula(R.drawable.titanic,"TITANIC","2002"));
        listaPeliculas.add(new Pelicula(R.drawable.ultimallamada,"ULTIMA LLAMADA","2017"));

        return listaPeliculas;
    }
}










