package com.example.catalogservice.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;

@Aspect
public class ValidateUser {

    @Autowired
    RestTemplate restTemplate;

    @Before("execution(* com.example.catalogservice.controller.*(..))")
    public void filter(JoinPoint joinPoint) throws URISyntaxException {

        Object[] signatureArgs = joinPoint.getArgs();

        HttpServletRequest header = (HttpServletRequest) signatureArgs[0];

        String authorization  = header.getHeader("Authorization");

        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:"+8080+"/users/me";
        URI uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", "authorization");
        HttpEntity<?> requestEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
        if(result.getStatusCodeValue() != 200){
              new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
