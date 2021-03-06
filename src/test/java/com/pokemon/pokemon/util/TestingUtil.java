package com.pokemon.pokemon.util;

import com.pokemon.pokemon.model.PokemonRsp;
import com.pokemon.pokemon.model.remote.funtranslations.TranslateContents;
import com.pokemon.pokemon.model.remote.funtranslations.TranslateShakespeareRsp;
import com.pokemon.pokemon.model.remote.funtranslations.TranslateSuccess;
import com.pokemon.pokemon.model.remote.pokeapi.PokeApiSpeciesRsp;
import com.pokemon.pokemon.model.remote.pokeapi.SpeciesFlavorTextEntries;
import com.pokemon.pokemon.model.remote.pokeapi.SpeciesLanguage;

import java.util.ArrayList;

public class TestingUtil {

    public static PokemonRsp getPokemonRsp() {
        return new PokemonRsp("TestPokemon", "Test Description");
    }

    public static TranslateShakespeareRsp getStringToShakespeareanRsp() {
        return new TranslateShakespeareRsp(new TranslateSuccess(), new TranslateContents("Test Translated", "shakespeare"));
    }

    public static Object getPokeApiSpeciesRsp() {
        ArrayList<SpeciesFlavorTextEntries> speciesFlavorTextEntries = new ArrayList<>();
        speciesFlavorTextEntries.add(new SpeciesFlavorTextEntries("Text", new SpeciesLanguage("en")));
        return new PokeApiSpeciesRsp(speciesFlavorTextEntries);
    }

    public static Object getPokeApiSpeciesMultipleLanagueRsp() {
        ArrayList<SpeciesFlavorTextEntries> speciesFlavorTextEntries = new ArrayList<>();
        speciesFlavorTextEntries.add(new SpeciesFlavorTextEntries("OuiOui", new SpeciesLanguage("fr")));
        speciesFlavorTextEntries.add(new SpeciesFlavorTextEntries("YesYes", new SpeciesLanguage("en")));
        return new PokeApiSpeciesRsp(speciesFlavorTextEntries);
    }
}
