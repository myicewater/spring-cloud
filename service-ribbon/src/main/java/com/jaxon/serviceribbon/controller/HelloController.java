package com.jaxon.serviceribbon.controller;


import com.jaxon.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    @Autowired
    DiscoveryClient discoveryClient;


    @ResponseBody
    @RequestMapping("hi")
    public String sayHi(@RequestParam String name){

        List<String> services = discoveryClient.getServices();
        for(String s: services){

            System.out.print(s+",");
        }

        return helloService.sayHi(name);
    }
}
