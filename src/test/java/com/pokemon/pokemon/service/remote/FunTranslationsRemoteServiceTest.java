package com.pokemon.pokemon.service.remote;

import com.pokemon.pokemon.util.TestingUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FunTranslationsRemoteServiceTest {

    @InjectMocks
    private FunTranslationsRemoteServiceImpl funTranslationsRemoteService;

    @Mock
    private RemoteCallingService remoteCallingService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(funTranslationsRemoteService);
    }

    @Test
    public void testTranslateStringToShakespearean(){
        when(remoteCallingService.remotePostCall(any(), any(), any())).thenReturn(TestingUtil.getStringToShakespeareanRsp());
        String translated = funTranslationsRemoteService.translateStringToShakespearean("Test");
        assertEquals("Test Translated", translated);
    }

    @Test
    public void testTranslateStringToShakespeareanError(){
        when(remoteCallingService.remotePostCall(any(), any(), any())).thenReturn(TestingUtil.getStringToShakespeareanRsp());
        String translated = funTranslationsRemoteService.translateStringToShakespearean("Test");
        assertEquals("Test Translated", translated);
    }

    @Test
    public void testTranslateStringToShakespeareanRateLimitError(){
        when(remoteCallingService.remotePostCall(any(), any(), any()))
                .thenThrow(HttpClientErrorException.create(HttpStatus.TOO_MANY_REQUESTS, "TOO MANY REQUESTS", new HttpHeaders(), new byte[0], Charset.defaultCharset()));
        Assertions.assertThrows(RuntimeException.class, () -> funTranslationsRemoteService.translateStringToShakespearean("Test"));
    }

}
