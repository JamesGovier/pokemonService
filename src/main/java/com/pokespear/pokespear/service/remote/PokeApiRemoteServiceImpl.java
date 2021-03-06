package com.pokespear.pokespear.service.remote;

import com.pokespear.pokespear.model.remote.pokeapi.PokeApiSpeciesRsp;
import com.pokespear.pokespear.model.remote.pokeapi.SpeciesFlavorTextEntries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class PokeApiRemoteServiceImpl implements PokeApiRemoteService {

    private String POKEMON_SPECIES_URL = "https://pokeapi.co/api/v2/pokemon-species/";

    @Autowired
    private final RemoteCallingService remoteCall;

    public PokeApiRemoteServiceImpl(RemoteCallingService remoteCall) {
        this.remoteCall = remoteCall;
    }

    @Override
    public String getPokemonDescription(String pokemon) {
        ArrayList<SpeciesFlavorTextEntries> flavor_text_entries = getPokemonSpecies(pokemon).getFlavor_text_entries();
        if(flavor_text_entries.size() > 0){
            //TODO the first flavor text isn't always in english we need the handle this
            return flavor_text_entries.get(0).getFlavor_text();
        }else{
            //TODO error handling as there's no results
            return null;
        }
    }

    @Override
    public PokeApiSpeciesRsp getPokemonSpecies(String pokemon) {
        return (PokeApiSpeciesRsp) remoteCall.remoteGetCall(POKEMON_SPECIES_URL + pokemon, new PokeApiSpeciesRsp());
    }
}
