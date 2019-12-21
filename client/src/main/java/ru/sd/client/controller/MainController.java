package ru.sd.client.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sd.client.service.ClientService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {

    private final ClientService clientService;

    @GetMapping("/rest")
    public ResponseEntity<String> restGet() {
        log.info("Request data");
        return ResponseEntity.ok(clientService.getDataByRestTemplate());
    }

    @GetMapping("/feign")
    public ResponseEntity<String> feignGet() {
        log.info("Request data");
        return ResponseEntity.ok(clientService.getDataByFeign());
    }
}
