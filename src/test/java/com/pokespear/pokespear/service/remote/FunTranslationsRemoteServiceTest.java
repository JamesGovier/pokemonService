package com.pokespear.pokespear.service.remote;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class FunTranslationsRemoteServiceTest {

    @InjectMocks
    private FunTranslationsRemoteServiceImpl funTranslationsRemoteService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(funTranslationsRemoteService);
    }

    @Test
    public void testTranslateStringToShakespearean(){
        //TODO remote call testing issues with mocking RestResponse
    }

    @Test
    public void testTranslateStringToShakespeareanError(){
        //TODO will test if the End point throws a breaking error
    }

    @Test
    public void testTranslateStringToShakespeareanRateLimitError(){
        //TODO will test when the end point reaches rate limit
    }

    @Test
    public void testTranslateStringToShakespeareanRequestInvalid(){
        //TODO will test if the request string is invalid
    }


}
