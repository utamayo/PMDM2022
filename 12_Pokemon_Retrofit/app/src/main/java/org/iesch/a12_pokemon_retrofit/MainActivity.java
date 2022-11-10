package org.iesch.a12_pokemon_retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.iesch.a12_pokemon_retrofit.model.Pokemon;
import org.iesch.a12_pokemon_retrofit.model.PokemonRespuesta;
import org.iesch.a12_pokemon_retrofit.pokeAPI.PokeapiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private Retrofit retrofit;
    //10
    private RecyclerView recyclerView;
    private ListaPokemonAdapter listaPokemonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 11 Hacemos las configuraciones iniciales en el RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        listaPokemonAdapter = new ListaPokemonAdapter();
        recyclerView.setAdapter(listaPokemonAdapter);
        //12 Nuestro GRID queremos que tenga 3 columnas
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        //13 Lo asignamos al recyclerview
        recyclerView.setLayoutManager(layoutManager);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        obtenerDatos();
    }

    private void obtenerDatos() {

        PokeapiService service = retrofit.create(PokeapiService.class);

        Call<PokemonRespuesta> pokemonRespuestaCall = service.obtenerListaPokemon();

        pokemonRespuestaCall.enqueue(new Callback<PokemonRespuesta>() {

            @Override
            public void onResponse(Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {

                if (response.isSuccessful()){
                    PokemonRespuesta pokemonRespuesta = response.body();

                    ArrayList<Pokemon> listaPokemon = pokemonRespuesta.getResults();

                    //14 - Cuando recibimos los datos ya no los mostramos por consola
                    //se los mandamos al adaptador por medio de un metodo
                    listaPokemonAdapter.adicionarPokemon(listaPokemon);
                }else{
                    Log.i("POKEMON", "onResponse: "+response.errorBody());
                }

            }

            @Override
            public void onFailure(Call<PokemonRespuesta> call, Throwable t) {
                Log.i("POKEMON", "onFailure: "+t.getMessage());
            }
        });
    }
}






























