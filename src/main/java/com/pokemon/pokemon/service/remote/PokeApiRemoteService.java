package com.pokemon.pokemon.service.remote;

import com.pokemon.pokemon.model.remote.pokeapi.PokeApiSpeciesRsp;

public interface PokeApiRemoteService {

    String getPokemonDescription(String pokemon);

    PokeApiSpeciesRsp getPokemonSpecies(String pokemon);
}
