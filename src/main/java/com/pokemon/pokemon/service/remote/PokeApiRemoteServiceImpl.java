package com.pokemon.pokemon.service.remote;

import com.pokemon.pokemon.contants.Constants;
import com.pokemon.pokemon.model.exception.NotFoundException;
import com.pokemon.pokemon.model.remote.pokeapi.PokeApiSpeciesRsp;
import com.pokemon.pokemon.model.remote.pokeapi.SpeciesFlavorTextEntries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PokeApiRemoteServiceImpl implements PokeApiRemoteService {

    @Autowired
    private final RemoteCallingService remoteCall;

    public PokeApiRemoteServiceImpl(RemoteCallingService remoteCall) {
        this.remoteCall = remoteCall;
    }

    @Override
    public String getPokemonDescription(String pokemon) {
        ArrayList<SpeciesFlavorTextEntries> flavor_text_entries = getPokemonSpecies(pokemon).getFlavor_text_entries();
        for(SpeciesFlavorTextEntries flavorTextEntry : flavor_text_entries){
            if(flavorTextEntry.getLanguage() != null){
                if(flavorTextEntry.getLanguage().getName().equals(Constants.POKEMON_SPECIES_DEFAULT_LANGUAGE)){
                    return flavorTextEntry.getFlavor_text();
                }
            }
        }
        throw new NotFoundException("Remote Error : Pokemon Description Not Found");
    }

    @Override
    public PokeApiSpeciesRsp getPokemonSpecies(String pokemon) {
        return (PokeApiSpeciesRsp) remoteCall.remoteGetCall(Constants.POKEMON_SPECIES_URL + pokemon, new PokeApiSpeciesRsp());
    }
}
