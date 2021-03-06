package com.pokespear.pokespear.controller;


import com.pokespear.pokespear.service.PokemonService;
import com.pokespear.pokespear.util.TestingUtil;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PokemonControllerTest {

    @InjectMocks
    private PokemonController controller;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PokemonService pokemonService;

    @Test
    public void testGetPokemon() throws Exception {
        when(pokemonService.getPokemonRsp(any())).thenReturn(TestingUtil.getPokemonRsp());
        mockMvc.perform(get("/pokemon/charizard")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"name\":\"TestPokemon\",\"description\":\"Test Description\"}")));
    }

    @Test
    public void testGetPokemonEmptyString() throws Exception {
        when(pokemonService.getPokemonRsp(any())).thenReturn(TestingUtil.getPokemonRsp());
        mockMvc.perform(get("/pokemon/")).andDo(print()).andExpect(status().isNotFound());
    }

}
