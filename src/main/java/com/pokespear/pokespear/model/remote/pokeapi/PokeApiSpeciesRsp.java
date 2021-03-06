package com.pokespear.pokespear.model.remote.pokeapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
public @Data class PokeApiSpeciesRsp {

    private ArrayList<SpeciesFlavorTextEntries> flavor_text_entries;

}
