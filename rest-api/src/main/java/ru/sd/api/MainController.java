package ru.sd.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
public class MainController {

    @Value("${info.app.name}")
    private String name;

    @GetMapping("/data")
    public ResponseEntity<String> data() {
        log.info("Request is here");
        return ResponseEntity.ok(name + " response " + LocalDateTime.now());
    }
}
