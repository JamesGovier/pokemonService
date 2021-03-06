package com.pokemon.pokemon.service.remote;

public interface FunTranslationsRemoteService {

    /**
     * Given a string will return a Shakespearean translation
     * This end point has a limit of 5 requests an hour for a given IP
     * Currently we just return the HTTPSTATUS 429 "Too many request"
     * We could cache requests send so that users would get some responses or just keep returning that error
     *
     * @param description the string description
     * @return Shakespearean translated string
     */
    String translateStringToShakespearean(String description);
}
