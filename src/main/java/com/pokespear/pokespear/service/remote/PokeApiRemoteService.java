package com.pokespear.pokespear.service.remote;

import com.pokespear.pokespear.model.remote.pokeapi.PokeApiSpeciesRsp;

public interface PokeApiRemoteService {

    String getPokemonDescription(String pokemon);

    PokeApiSpeciesRsp getPokemonSpecies(String pokemon);
}
