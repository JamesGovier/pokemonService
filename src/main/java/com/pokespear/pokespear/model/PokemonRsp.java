package com.pokespear.pokespear.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public @Data class PokemonRsp {

    private String name;

    private String description;

}
