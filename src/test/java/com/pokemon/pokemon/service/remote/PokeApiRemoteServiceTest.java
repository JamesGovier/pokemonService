package com.pokemon.pokemon.service.remote;

import com.pokemon.pokemon.model.remote.pokeapi.PokeApiSpeciesRsp;
import com.pokemon.pokemon.util.TestingUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PokeApiRemoteServiceTest {

    @InjectMocks
    private PokeApiRemoteServiceImpl pokeApiRemoteService;

    @Mock
    private RemoteCallingService remoteCallingService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(pokeApiRemoteService);
    }

    @Test
    public void testGetPokemonDescription(){
        when(remoteCallingService.remoteGetCall(any(), any())).thenReturn(TestingUtil.getPokeApiSpeciesRsp());
        String pokemonDescription = pokeApiRemoteService.getPokemonDescription("Test");
        assertEquals("Text", pokemonDescription);
    }

    @Test
    public void testGetPokemonDescriptionFilteringNonEnLanguage(){
        when(remoteCallingService.remoteGetCall(any(), any())).thenReturn(TestingUtil.getPokeApiSpeciesMultipleLanagueRsp());
        String pokemonDescription = pokeApiRemoteService.getPokemonDescription("Test");
        assertEquals("YesYes", pokemonDescription);
    }

    @Test
    public void testGetPokemonDescriptionError(){
        when(remoteCallingService.remoteGetCall(any(), any()))
                .thenThrow(HttpClientErrorException.create(HttpStatus.NOT_FOUND, "Not Found", new HttpHeaders(), new byte[0], Charset.defaultCharset()));
        Assertions.assertThrows(RuntimeException.class, () -> pokeApiRemoteService.getPokemonDescription("Test"));
    }

    @Test
    public void testGetPokemonSpecies(){
        when(remoteCallingService.remoteGetCall(any(), any())).thenReturn(TestingUtil.getPokeApiSpeciesRsp());
        PokeApiSpeciesRsp pokeApiSpeciesRsp = pokeApiRemoteService.getPokemonSpecies("Test");
        assertEquals(1, pokeApiSpeciesRsp.getFlavor_text_entries().size());
        assertEquals("Text", pokeApiSpeciesRsp.getFlavor_text_entries().get(0).getFlavor_text());

    }

    @Test
    public void testGetPokemonSpeciesError(){
        when(remoteCallingService.remoteGetCall(any(), any()))
                .thenThrow(HttpClientErrorException.create(HttpStatus.NOT_FOUND, "Not Found", new HttpHeaders(), new byte[0], Charset.defaultCharset()));
        Assertions.assertThrows(RuntimeException.class, () -> pokeApiRemoteService.getPokemonSpecies("Test"));
    }

}
