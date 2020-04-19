package com.jaxon.feign.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-produce",fallback = ServiceFeignHystric.class)
public interface ServiceFeignSayHi {

    @RequestMapping(value="/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam(value="name") String name);
}
