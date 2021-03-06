package com.pokespear.pokespear.service.remote;

public interface FunTranslationsRemoteService {

    /**
     * Given a string will return a Shakespearean translation
     * @param description the string description
     * @return Shakespearean translated string
     */
    String translateStringToShakespearean(String description);
}
