package com.pokespear.pokespear.service;

import com.pokespear.pokespear.model.PokemonRsp;
import com.pokespear.pokespear.service.remote.FunTranslationsRemoteService;
import com.pokespear.pokespear.service.remote.PokeApiRemoteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PokemonServiceTest {

    @Mock
    private FunTranslationsRemoteService funTranslationsRemoteService;

    @Mock
    private PokeApiRemoteService pokeApiRemoteService;

    @InjectMocks
    private PokemonServiceImpl pokemonService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(pokemonService);
    }

    @Test
    public void testGetPokemonRsp(){
        when(pokeApiRemoteService.getPokemonDescription(any())).thenReturn("This is a test description that hasn't been translated");
        when(funTranslationsRemoteService.translateStringToShakespearean(any())).thenReturn("This is a test description that has been translated");

        PokemonRsp testPokemon = pokemonService.getPokemonRsp("TestPokemon");
        assertEquals("This is a test description that has been translated", testPokemon.getDescription());
        assertEquals("TestPokemon", testPokemon.getName());
    }

    @Test
    public void testGetPokemonRspErrorTranslate(){
        when(pokeApiRemoteService.getPokemonDescription(any())).thenReturn("This is a test description that hasn't been translated");
        when(funTranslationsRemoteService.translateStringToShakespearean(any())).thenThrow(new RuntimeException());
        Assertions.assertThrows(RuntimeException.class, () -> pokemonService.getPokemonRsp("TestPokemon"));
    }

    @Test
    public void testGetPokemonRspErrorPokeApi(){
        when(pokeApiRemoteService.getPokemonDescription(any())).thenThrow(new RuntimeException());
        when(funTranslationsRemoteService.translateStringToShakespearean(any())).thenReturn("This is a test description that has been translated");
        Assertions.assertThrows(RuntimeException.class, () -> pokemonService.getPokemonRsp("TestPokemon"));
    }

    //TODO test for enhanced validation

}
