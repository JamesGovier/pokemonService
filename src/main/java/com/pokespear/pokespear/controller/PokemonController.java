package com.pokespear.pokespear.controller;

import com.pokespear.pokespear.model.PokemonRsp;
import com.pokespear.pokespear.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemon/{pokemon}")
    public @ResponseBody PokemonRsp getPokemon(@PathVariable String pokemon){
        //TODO validation of pathVariable
        return pokemonService.getPokemonRsp(pokemon);
    }

}
