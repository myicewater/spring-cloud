package com.jaxon.feign;

import com.jaxon.feign.service.ServiceFeignSayHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    ServiceFeignSayHi serviceFeignSayHi;

    @GetMapping("/hi")
    public String sayHi(@RequestParam String name){
        return serviceFeignSayHi.sayHi(name);
    }
}
