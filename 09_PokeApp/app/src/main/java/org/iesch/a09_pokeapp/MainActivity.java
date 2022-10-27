package org.iesch.a09_pokeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.iesch.a09_pokeapp.fragments.DetailFragment;
import org.iesch.a09_pokeapp.model.Pokemon;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements iComunicaFragments, View.OnClickListener {

    DetailFragment detalleFragmentPokemon;
    private TextView imageTextView;
    private TextView statsTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Lista Pokemon");
        // 1 - Declaramoslos botones
        imageTextView = findViewById(R.id.activity_main_image_opcion_tv);
        statsTextView = findViewById(R.id.activity_main_opcion_estadisticas_tv);

        imageTextView.setBackgroundColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_dark_default_color_primary));
        statsTextView.setBackgroundColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_dark_default_color_secondary));

        // 2 Controlamos los botones
        imageTextView.setOnClickListener(this);
        statsTextView.setOnClickListener(this);
    }

    @Override
    public void enviarPokemon(Pokemon pokemon) {
        // esto sirve para comunicar los fragments
        // Toast.makeText(this, pokemon.getName(), Toast.LENGTH_SHORT).show();

        // Aqui realizaremos tod ala logica necesaria para comunicar los Fragments
        detalleFragmentPokemon = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.pokemon_detail_fragment);
        detalleFragmentPokemon.setPokemonImage(pokemon.getImageUrl());
        detalleFragmentPokemon.playPokemonSound(pokemon.getSoundId());
    }
    // 3
    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId){
            case R.id.activity_main_image_opcion_tv:
                imageTextView.setBackgroundColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_dark_default_color_primary));
                statsTextView.setBackgroundColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_dark_default_color_secondary));
                break;
            case R.id.activity_main_opcion_estadisticas_tv:
                statsTextView.setBackgroundColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_dark_default_color_primary));
                imageTextView.setBackgroundColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_dark_default_color_secondary));
                break;
        }
    }
}



















