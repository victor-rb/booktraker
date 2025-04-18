package com.vctr.booktraker.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LambdaCallerService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${lambda.endpoint}")
    private String uri;

    public ResponseEntity<String> getTopBooksLambda(String message){
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        String payload = "{}";
        HttpEntity<String> entity = new HttpEntity<>(payload, headers);

        return restTemplate.postForEntity(uri, entity, String.class);
    }
}
