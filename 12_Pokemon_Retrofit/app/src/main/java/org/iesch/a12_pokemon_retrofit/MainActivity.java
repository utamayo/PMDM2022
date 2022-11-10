package org.iesch.a12_pokemon_retrofit;

import androidx.annotation.NonNull;
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

    private RecyclerView recyclerView;
    private ListaPokemonAdapter listaPokemonAdapter;
    // C 1
    private int offset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        listaPokemonAdapter = new ListaPokemonAdapter(this);
        recyclerView.setAdapter(listaPokemonAdapter);

        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);

        recyclerView.setLayoutManager(layoutManager);

        // D - Nuestro RecyclerView detecta el movimiento con este Scroll
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                // D 2 - Hacemos una serie de preguntas para preguntar si el scroll es hacia abajo y llegó al ulyimo item
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();
                if (aptoParaCargar){
                    if ((visibleItemCount + pastVisibleItems) >= totalItemCount){
                        Log.i("POKEMON","Llegamos al Final");
                        aptoParaCargar = false;
                        offset += 20;
                        obtenerDatos(offset);
                    }
                }

            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // C 2
        offset=0;
        obtenerDatos(offset);
    }

    private void obtenerDatos(int offset) {

        PokeapiService service = retrofit.create(PokeapiService.class);

        // B - Colocamos los parametros, limit sera 20, pero offset tiene que cambiar
        Call<PokemonRespuesta> pokemonRespuestaCall = service.obtenerListaPokemon(20, 20);

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






























