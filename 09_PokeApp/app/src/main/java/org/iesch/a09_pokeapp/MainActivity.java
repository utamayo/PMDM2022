package org.iesch.a09_pokeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.iesch.a09_pokeapp.fragments.DetailFragment;
import org.iesch.a09_pokeapp.fragments.StatsFragment;
import org.iesch.a09_pokeapp.model.Pokemon;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements iComunicaFragments, View.OnClickListener {

    // 6 Para no confundir las opciones con los numeros creamos lo siguiente
    private static final int OPTION_DETAIL = 0;
    private static final int OPTION_STATS = 1;

    DetailFragment detalleFragmentPokemon;
    private TextView imageTextView;
    private TextView statsTextView;
    // 2
    private Pokemon selectedPokemon;
    // 4
    private int selectedOption;
    // 7
    private Fragment currentFragment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Lista Pokemon");

        imageTextView = findViewById(R.id.activity_main_image_opcion_tv);
        statsTextView = findViewById(R.id.activity_main_opcion_estadisticas_tv);

        imageTextView.setBackgroundColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_dark_default_color_primary));
        statsTextView.setBackgroundColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_dark_default_color_secondary));


        imageTextView.setOnClickListener(this);
        statsTextView.setOnClickListener(this);
    }

    @Override
    public void enviarPokemon(Pokemon pokemon) {
        selectedPokemon = pokemon;
        // 9
        setFragmentAndContent();

    }
    // 3
    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId){
            case R.id.activity_main_image_opcion_tv:
                // 5- al seleccionar la opcion de la izquierda lo ponemos a 0
                selectedOption = OPTION_DETAIL;
                imageTextView.setBackgroundColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_dark_default_color_primary));
                statsTextView.setBackgroundColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_dark_default_color_secondary));
                break;
            case R.id.activity_main_opcion_estadisticas_tv:
                selectedOption = OPTION_STATS;
                statsTextView.setBackgroundColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_dark_default_color_primary));
                imageTextView.setBackgroundColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_dark_default_color_secondary));
                break;
        }
        // 10
        setFragmentAndContent();
    }

    // 7 - Creamos un nuevo metodo para asignar el fragment dependiendo de la opcion seleccionada
    private void setFragmentAndContent(){
        if (selectedPokemon != null){
            if (selectedOption == OPTION_DETAIL){
                currentFragment = DetailFragment.newInstance(selectedPokemon.getImageUrl(),selectedPokemon.getSoundId());
            } else if (selectedOption == OPTION_STATS){
                currentFragment = StatsFragment.newInstance(selectedPokemon.getStats());
                // 8 Ahora falta asignar el contenedor que acabamos de crear con el contenedor que se muestra
            }
            FragmentTransaction fragmentTransaction =  getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.pokemon_detail_container, currentFragment);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(this, "Debes seleccionar un Pokemon primero", Toast.LENGTH_SHORT).show();
        }
    }







}



















