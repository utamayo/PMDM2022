package org.iesch.a09_pokeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.iesch.a09_pokeapp.fragments.DetailFragment;
import org.iesch.a09_pokeapp.model.Pokemon;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements iComunicaFragments {

    DetailFragment detalleFragmentPokemon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Lista Pokemon");
    }

    @Override
    public void enviarPokemon(Pokemon pokemon) {
        // esto sirve para comunicar los fragments
        // Toast.makeText(this, pokemon.getName(), Toast.LENGTH_SHORT).show();

        // Aqui realizaremos tod ala logica necesaria para comunicar los Fragments
        detalleFragmentPokemon = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.pokemon_detail_fragment);
        detalleFragmentPokemon.setPokemonImage(pokemon.getImageId());
        detalleFragmentPokemon.playPokemonSound(pokemon.getSoundId());
    }
}



















