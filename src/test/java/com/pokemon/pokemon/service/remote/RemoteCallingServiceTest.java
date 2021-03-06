package com.pokemon.pokemon.service.remote;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.MOCK)
public class RemoteCallingServiceTest {

    @InjectMocks
    private RemoteCallingServiceImpl remoteCallingService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(remoteCallingService);
    }

    @Test
    public void testGetDefaultHeaders(){
        HttpHeaders defaultHeaders = remoteCallingService.getDefaultHeaders();
        assertEquals(1,defaultHeaders.size());
        assertEquals("[application/json]", Objects.requireNonNull(defaultHeaders.get("Content-Type")).toString());
    }


}
