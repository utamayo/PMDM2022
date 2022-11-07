package org.iesch.a12_pokemon_retrofit;

import androidx.appcompat.app.AppCompatActivity;

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

    // 1 -Creamos una instancia de Retrofit
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 2 - Accemos accesible la clase
        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/") // Es la parte que NO CAMBIA de la URL
                .addConverterFactory(GsonConverterFactory.create()) // Definimos cómo vamos a formatear nuestras respuestas
                .build();
        // 3 - Nos creamos un método que se encargará de obtener los datos
        obtenerDatos();
    }

    private void obtenerDatos() {
        // La manera de trabajar con Retrofit es crearnos una interfaz de Java que se pondran todos los metodos a usar
        // 7 - Usamos la interfaz que acabamos de crear
        PokeapiService service = retrofit.create(PokeapiService.class);
        // 8 - Nuestra variable service ya puede llamar a la variable que acabamos de crear
        Call<PokemonRespuesta> pokemonRespuestaCall = service.obtenerListaPokemon();
        // 9 - Usaremos el metodo enqueue para MANEJAR LOS RESULTADOS en sus metodos internos
        pokemonRespuestaCall.enqueue(new Callback<PokemonRespuesta>() {
            // Este metodo se ejecuta cuando llega la respuesta a la consulta que hicimos
            @Override
            public void onResponse(Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {
                // Cuando llega una respuesta esta no siempre puede ser exitosa y devolvernos los datos
                if (response.isSuccessful()){
                    PokemonRespuesta pokemonRespuesta = response.body();
                    // 10 - Ahora solo nos queda comprobar la informacion que llega
                    ArrayList<Pokemon> listaPokemon = pokemonRespuesta.getResults();

                    for (int i=0; i < listaPokemon.size(); i++){
                        Pokemon p = listaPokemon.get(i);
                        Log.i("LISTA_POKEMON", "Pokemon: "+p.getName());
                    }
                }else{
                    Log.i("POKEMON", "onResponse: "+response.errorBody());
                }

            }
            // Este método se ejecuta cuando ha habido algún tipo de error
            // No hay conexion a internet, agotado tiempo de espera... u otro
            @Override
            public void onFailure(Call<PokemonRespuesta> call, Throwable t) {
                Log.i("POKEMON", "onFailure: "+t.getMessage());
            }
        });
    }
}






























