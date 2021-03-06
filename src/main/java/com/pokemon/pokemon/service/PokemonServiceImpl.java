package com.pokemon.pokemon.service;

import com.pokemon.pokemon.model.PokemonRsp;
import com.pokemon.pokemon.service.remote.FunTranslationsRemoteService;
import com.pokemon.pokemon.service.remote.PokeApiRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokeApiRemoteService pokeApiRemoteService;

    private final FunTranslationsRemoteService funTranslationsRemoteService;

    @Autowired
    public PokemonServiceImpl(PokeApiRemoteService pokeApiRemoteService, FunTranslationsRemoteService funTranslationsRemoteService) {
        this.pokeApiRemoteService = pokeApiRemoteService;
        this.funTranslationsRemoteService = funTranslationsRemoteService;
    }

    @Override
    public PokemonRsp getPokemonRsp(String pokemon) {
        String description = pokeApiRemoteService.getPokemonDescription(pokemon);
        String translatedDescription = funTranslationsRemoteService.translateStringToShakespearean(description);
        return new PokemonRsp(pokemon, translatedDescription);
    }

}
