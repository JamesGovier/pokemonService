package com.pokespear.pokespear.service.remote;

import com.pokespear.pokespear.model.remote.funtranslations.TranslateShakespeareRqst;
import com.pokespear.pokespear.model.remote.funtranslations.TranslateShakespeareRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import static com.pokespear.pokespear.contants.Constants.SHAKESPEARE_TRANSLATE_URL;

@Service
public class FunTranslationsRemoteServiceImpl implements FunTranslationsRemoteService {

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
                (TranslateShakespeareRsp) remoteCallingService.remotePostCall(SHAKESPEARE_TRANSLATE_URL, new TranslateShakespeareRsp(), new HttpEntity<>(translateShakespeareRqst, remoteCallingService.getDefaultHeaders()));
        return response.getContents().getTranslated();
    }

}
