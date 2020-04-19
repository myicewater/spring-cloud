package com.jaxon.feign.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceFeignHystric implements ServiceFeignSayHi {
    @Override
    public String sayHi(String name) {
        return "hi "+name +" say hi err";
    }
}
