package org.iesch.a12_pokemon_retrofit.pokeAPI;

import org.iesch.a12_pokemon_retrofit.model.PokemonRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeapiService {
    // 4 - En esta ocasion solo vamos a acceder al listado de los pokemon
    // El tipo de retorno SIEMPRE ca a ser un objeto de tipo Call
    // Tenemos que especificar que accion usará y con qué URL
    @GET("pokemon")
    Call<PokemonRespuesta> obtenerListaPokemon();
}
