package org.iesch.a09_pokeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.iesch.a09_pokeapp.model.Pokemon;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 9
    private ListView lvPokemon;
    private PokemonListAdapter adaptador;
    private ArrayList<Pokemon> pokemonList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Lista Pokemon");
        // 10 - Lo enlazo
        lvPokemon = findViewById(R.id.listaPokemon);
        // 11
        pokemonList.add(new Pokemon("1", "Bulbasaur",Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("2", "Ivysaur",Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("3", "VenuaSaur",Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("4", "Charmander",Pokemon.Type.FIRE));
        pokemonList.add(new Pokemon("5", "Charmeleon",Pokemon.Type.WATER));
        pokemonList.add(new Pokemon("6", "Charizard",Pokemon.Type.FIRE));
        pokemonList.add(new Pokemon("7", "Squirtle",Pokemon.Type.WATER));
        pokemonList.add(new Pokemon("8", "Blastoise",Pokemon.Type.ELECTRIC));
        pokemonList.add(new Pokemon("25", "Pikachu",Pokemon.Type.ELECTRIC));
        pokemonList.add(new Pokemon("26", "Raichu",Pokemon.Type.ELECTRIC));
        // 12
        adaptador = new PokemonListAdapter(this, pokemonList, R.id.listaPokemon);
        // 13 - Asignamos el adaptador al ListView
        lvPokemon.setAdapter(adaptador);
        // 14 - Me creo un metodo para tener control sobre el elemento que selecciono
        lvPokemon.setOnItemClickListener((parent, view, position, id) -> {
            Pokemon selectedPokemon = (Pokemon) adaptador.getItem(position);
            if (selectedPokemon != null){
                Toast.makeText(MainActivity.this, selectedPokemon.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}



















