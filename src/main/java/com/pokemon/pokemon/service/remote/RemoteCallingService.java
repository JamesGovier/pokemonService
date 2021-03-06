package com.pokemon.pokemon.service.remote;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

public interface RemoteCallingService {

    /**
     * Performs a remote get call for a given url
     * @param url url to call
     * @param responseObject object to map response to
     * @return object mapped by responseObject
     */
    Object remoteGetCall(String url, Object responseObject);


    /**
     * Performs a remote post call for a given url and request body
     * @param url url
     * @param responseObject object to map response to
     * @param request the current request as an Entity
     * @param <T> Class type for the request obejct
     * @return object mapped by responseObject
     */
    <T> Object remotePostCall(String url, Object responseObject, HttpEntity<T> request);

    /**
     * Default post headers
     * @return the default headers for a post request
     */
    HttpHeaders getDefaultHeaders();
}
