package com.pokemon.pokemon.service.remote;

import com.pokemon.pokemon.contants.Constants;
import com.pokemon.pokemon.model.remote.funtranslations.TranslateShakespeareRqst;
import com.pokemon.pokemon.model.remote.funtranslations.TranslateShakespeareRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

@Service
public class FunTranslationsRemoteServiceImpl implements FunTranslationsRemoteService {

    @Autowired
    private final RemoteCallingService remoteCallingService;

    public FunTranslationsRemoteServiceImpl(RemoteCallingService remoteCallingService) {
        this.remoteCallingService = remoteCallingService;
    }

    @Override
    public String translateStringToShakespearean(String description) {
        TranslateShakespeareRqst translateShakespeareRqst = new TranslateShakespeareRqst(description);
        TranslateShakespeareRsp response =
                (TranslateShakespeareRsp) remoteCallingService.remotePostCall(Constants.SHAKESPEARE_TRANSLATE_URL, new TranslateShakespeareRsp(), new HttpEntity<>(translateShakespeareRqst, remoteCallingService.getDefaultHeaders()));
        return response.getContents().getTranslated();
    }

}
