package com.pokespear.pokespear.model.remote.pokeapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class SpeciesFlavorTextEntries {

    private String flavor_text;

    private SpeciesLanguage language;

}
