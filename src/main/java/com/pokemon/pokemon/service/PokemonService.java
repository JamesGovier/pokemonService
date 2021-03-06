package com.pokemon.pokemon.service;

import com.pokemon.pokemon.model.PokemonRsp;


public interface PokemonService {

    /**
     * Gets a pokemon with a given description
     *
     * @param pokemon name of the pokemon to get
     * @return a pokemon description
     */
    PokemonRsp getPokemonRsp(String pokemon);
}
