package com.jaxon.serviceribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    public String sayHi(String name){
        return restTemplate.getForObject("http://service-produce/hi?name="+name,String.class);
    }
}
