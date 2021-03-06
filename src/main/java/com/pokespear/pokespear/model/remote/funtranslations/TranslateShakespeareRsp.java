package com.pokespear.pokespear.model.remote.funtranslations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class TranslateShakespeareRsp {

    private TranslateSuccess success;

    private TranslateContents contents;

}
