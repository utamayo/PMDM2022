package org.iesch.a12_pokemon_retrofit.model;

import java.util.ArrayList;

public class PokemonRespuesta {
    // 5 - Tenemos que poner los atributos de aquella informacion que nos interesa del JSON
    // en nuestro caso nos interesan los results
    private ArrayList<Pokemon> results;

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
