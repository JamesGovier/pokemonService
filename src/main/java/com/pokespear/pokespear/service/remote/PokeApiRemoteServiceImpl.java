package com.pokespear.pokespear.service.remote;

import com.pokespear.pokespear.model.exception.NotFoundException;
import com.pokespear.pokespear.model.remote.pokeapi.PokeApiSpeciesRsp;
import com.pokespear.pokespear.model.remote.pokeapi.SpeciesFlavorTextEntries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.pokespear.pokespear.contants.Constants.POKEMON_SPECIES_DEFAULT_LANGUAGE;
import static com.pokespear.pokespear.contants.Constants.POKEMON_SPECIES_URL;

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
                if(flavorTextEntry.getLanguage().getName().equals(POKEMON_SPECIES_DEFAULT_LANGUAGE)){
                    return flavorTextEntry.getFlavor_text();
                }
            }
        }
        throw new NotFoundException("Remote Error : Pokemon Description Not Found");
    }

    @Override
    public PokeApiSpeciesRsp getPokemonSpecies(String pokemon) {
        return (PokeApiSpeciesRsp) remoteCall.remoteGetCall(POKEMON_SPECIES_URL + pokemon, new PokeApiSpeciesRsp());
    }
}
