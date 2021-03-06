package com.pokemon.pokemon.controller;

import com.pokemon.pokemon.model.PokemonRsp;
import com.pokemon.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
public class PokemonController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemon/{pokemon}")
    public @ResponseBody
    PokemonRsp getPokemon(@PathVariable @Valid @NotNull String pokemon){
        return pokemonService.getPokemonRsp(pokemon);
    }

}
