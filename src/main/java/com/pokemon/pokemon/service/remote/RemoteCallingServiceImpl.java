package com.pokemon.pokemon.service.remote;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class RemoteCallingServiceImpl implements RemoteCallingService {

    @Override
    public Object remoteGetCall(String url, Object responseObject) throws HttpClientErrorException {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, responseObject.getClass());
    }

    @Override
    public <T> Object remotePostCall(String url, Object responseObject, HttpEntity<T> request) throws HttpClientErrorException {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url,request, responseObject.getClass());
    }

    public HttpHeaders getDefaultHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
