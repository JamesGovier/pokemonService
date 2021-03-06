package com.pokespear.pokespear.service.remote;

import com.pokespear.pokespear.model.remote.pokeapi.PokeApiSpeciesRsp;
import com.pokespear.pokespear.util.TestingUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PokeApiRemoteServiceTest {

    @InjectMocks
    private PokeApiRemoteService pokeApiRemoteService;

    @Mock
    private RemoteCallingService remoteCallingService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(pokeApiRemoteService);
    }

    @Test
    private void testGetPokemonDescription(){
        when(remoteCallingService.remoteGetCall(any(), any())).thenReturn(TestingUtil.getStringToShakespeareanRsp());
        String translated = pokeApiRemoteService.getPokemonDescription("Test");
        assertEquals("Test Translated", translated);
    }

    @Test
    private void testGetPokemonDescriptionFilteringNonEnLanguage(){
        //TODO once implemented
    }

    @Test
    private void testGetPokemonDescriptionError(){
        when(remoteCallingService.remoteGetCall(any(), any()))
                .thenThrow(HttpClientErrorException.create(HttpStatus.NOT_FOUND, "Not Found", new HttpHeaders(), new byte[0], Charset.defaultCharset()));
        Assertions.assertThrows(RuntimeException.class, () -> pokeApiRemoteService.getPokemonDescription("Test"));
    }

    @Test
    private void testGetPokemonSpecies(){
        when(remoteCallingService.remoteGetCall(any(), any())).thenReturn(TestingUtil.getPokeApiSpeciesRsp());
        PokeApiSpeciesRsp pokeApiSpeciesRsp = pokeApiRemoteService.getPokemonSpecies("Test");
        assertEquals(1, pokeApiSpeciesRsp.getFlavor_text_entries().size());
        assertEquals("Text", pokeApiSpeciesRsp.getFlavor_text_entries().get(0).getFlavor_text());

    }

    @Test
    private void testGetPokemonSpeciesError(){
        when(remoteCallingService.remoteGetCall(any(), any()))
                .thenThrow(HttpClientErrorException.create(HttpStatus.NOT_FOUND, "Not Found", new HttpHeaders(), new byte[0], Charset.defaultCharset()));
        Assertions.assertThrows(RuntimeException.class, () -> pokeApiRemoteService.getPokemonSpecies("Test"));
    }

}
