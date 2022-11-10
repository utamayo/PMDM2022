package org.iesch.a12_pokemon_retrofit.pokeAPI;

import org.iesch.a12_pokemon_retrofit.model.PokemonRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokeapiService {
   // A - Modificamos el método para que sea parametrizable
    @GET("pokemon")
    Call<PokemonRespuesta> obtenerListaPokemon(@Query("limit") int limit, @Query("offset") int offset);
}
