package ru.sd.client.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.sd.client.config.OpenFeignClient;
import ru.sd.client.service.ClientService;

@Component
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final RestTemplate restTemplate;
    private final OpenFeignClient feignClient;

    @Override
    @HystrixCommand(fallbackMethod = "reliable")
    public String getDataByRestTemplate() {
        return restTemplate.getForEntity("http://rest-api/api/data", String.class).getBody();
    }

    @Override
    @HystrixCommand(fallbackMethod = "reliable")
    public String getDataByFeign() {
        return feignClient.getData();
    }

    @SuppressWarnings("unused")
    public String reliable() {
        return "Something went wrong";
    }
}
