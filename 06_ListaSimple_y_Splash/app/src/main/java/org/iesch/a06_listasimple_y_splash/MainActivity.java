package org.iesch.a06_listasimple_y_splash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lista;
    List<String> versionesAndroidList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Lista Simple");

        // 1 - Conectamos nuestro ListView al componente visual del id
        lista = findViewById(R.id.listView);
        // 2 - Cargamos la lista de elementos
        versionesAndroidList = new ArrayList<>();
        versionesAndroidList.add("Pie");
        versionesAndroidList.add("Oreo");
        versionesAndroidList.add("Nougat");
        versionesAndroidList.add("Marshmallow");
        versionesAndroidList.add("Lollipop");
        versionesAndroidList.add("KitKat");
        versionesAndroidList.add("JellyBean");
        versionesAndroidList.add("Ice Cream");
        versionesAndroidList.add("...");
        // 3 - Definimos el Adaptador
        // Transformará la lista de String al formato visualizable en la lista, pintándolos como elementos visuales.
        // Vamos a usar una plantilla por defecto que tiene Android (Una simple de cadena de caracteres)
        ArrayAdapter adaptadorVersionesAndroid = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1, // Template que vamos a utilizar para pintar los elementos
                versionesAndroidList  // le decimos la lista que queremos cargar en nuestro ListView
        );
        // 4 - Vinculamos el adaptador con el ListView pertinente
        lista.setAdapter(adaptadorVersionesAndroid);
        // 5 - Gestionamos los eventos click sobre los elementos de la lista
        lista.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // En este metodo debemos escribir el codigo necesario cuando el usuario haga click sobre
        //cualquier elemento de la lista.
        // La posicion del elemento e  la que hemos hecho click viene determinada por position
        String nombreVersion = versionesAndroidList.get(position);
        Toast.makeText(this, "Nombre de la version: " + nombreVersion, Toast.LENGTH_SHORT).show();
        Log.i("APPLISTA",nombreVersion);
    }
}











































