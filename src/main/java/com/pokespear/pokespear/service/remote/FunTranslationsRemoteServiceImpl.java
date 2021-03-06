package com.pokespear.pokespear.service.remote;

import com.pokespear.pokespear.model.remote.funtranslations.TranslateShakespeareRqst;
import com.pokespear.pokespear.model.remote.funtranslations.TranslateShakespeareRsp;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FunTranslationsRemoteServiceImpl implements FunTranslationsRemoteService {

    @Override
    public String translateStringToShakespearean(String description) {
        //TODO refactor URLs to a constant file
        String url = "https://api.funtranslations.com/translate/shakespeare.json";
        //TODO request validation
        TranslateShakespeareRqst translateShakespeareRqst = new TranslateShakespeareRqst(description);
        //TODO this end point has a rate limit of 5/hour, we should either just send back description or an error the client
        TranslateShakespeareRsp response = (TranslateShakespeareRsp) remoteCall(url, new TranslateShakespeareRsp(), new HttpEntity<>(translateShakespeareRqst, getDefaultHeaders()));
        return response.getContents().getTranslated();
    }


    //TODO extract this to a generic class so it can be re-used
    private <T> Object remoteCall(String url, Object responseObject, HttpEntity<T> request){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url,request, responseObject.getClass());
    }

    //TODO extract to generic class
    private HttpHeaders getDefaultHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

}
