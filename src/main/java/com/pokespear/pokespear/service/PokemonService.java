package com.pokespear.pokespear.service;

import com.pokespear.pokespear.model.PokemonRsp;


public interface PokemonService {

    /**
     * Gets a pokemon with a given description
     *
     * @param pokemon name of the pokemon to get
     * @return a pokemon description
     */
    PokemonRsp getPokemonRsp(String pokemon);
}
