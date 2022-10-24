package org.iesch.a09_pokeapp;

import org.iesch.a09_pokeapp.model.Pokemon;

public interface iComunicaFragments {
    // 8 - Esta interfaz sirve como puente para comunicar los fragments
    public void enviarPokemon(Pokemon pokemon);
}
