package com.pokespear.pokespear.util;

import com.pokespear.pokespear.model.PokemonRsp;
import com.pokespear.pokespear.model.remote.funtranslations.TranslateContents;
import com.pokespear.pokespear.model.remote.funtranslations.TranslateShakespeareRsp;
import com.pokespear.pokespear.model.remote.funtranslations.TranslateSuccess;

public class TestingUtil {

    public static PokemonRsp getPokemonRsp() {
        return new PokemonRsp("TestPokemon", "Test Description");
    }

    public static TranslateShakespeareRsp getStringToShakespeareanRsp() {
        return new TranslateShakespeareRsp(new TranslateSuccess(), new TranslateContents("shakespeare", "Test Translated"));
    }
}
