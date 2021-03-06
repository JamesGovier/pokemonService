package com.pokespear.pokespear.service.remote;

import com.pokespear.pokespear.model.remote.funtranslations.TranslateShakespeareRqst;
import com.pokespear.pokespear.model.remote.funtranslations.TranslateShakespeareRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

@Service
public class FunTranslationsRemoteServiceImpl implements FunTranslationsRemoteService {

    private static final String SHAKESPEARE_TRANSLATE = "https://api.funtranslations.com/translate/shakespeare.json";

    @Autowired
    private final RemoteCallingService remoteCallingService;

    public FunTranslationsRemoteServiceImpl(RemoteCallingService remoteCallingService) {
        this.remoteCallingService = remoteCallingService;
    }

    @Override
    public String translateStringToShakespearean(String description) {
        //TODO validation on response
        TranslateShakespeareRqst translateShakespeareRqst = new TranslateShakespeareRqst(description);
        TranslateShakespeareRsp response =
                (TranslateShakespeareRsp) remoteCallingService.remotePostCall(SHAKESPEARE_TRANSLATE, new TranslateShakespeareRsp(), new HttpEntity<>(translateShakespeareRqst, remoteCallingService.getDefaultHeaders()));
        return response.getContents().getTranslated();
    }

}
