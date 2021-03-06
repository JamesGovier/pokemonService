package com.pokespear.pokespear.service.remote;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

public class PokeApiRemoteServiceTest {

    @InjectMocks
    private PokeApiRemoteService pokeApiRemoteService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(pokeApiRemoteService);
    }

    @Test
    private void testGetPokemonDescription(){

    }

    @Test
    private void testGetPokemonDescriptionError(){

    }

    @Test
    private void testGetPokemonSpecies(){

    }

    @Test
    private void testGetPokemonSpeciesError(){

    }

}
