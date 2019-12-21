package ru.sd.client.config;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("rest-api")
public interface OpenFeignClient {
    @RequestMapping(method = RequestMethod.GET, value = "/api/data")
    String getData();
}
