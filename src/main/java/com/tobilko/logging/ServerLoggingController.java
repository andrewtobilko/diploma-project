package com.tobilko.logging;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ServerLoggingController {

    private final ServerLoggingService service;

    @GetMapping("/api/logging")
    public List<String> fetchLatestLoggerMessages() {
        return service.fetchLatestLoggerMessages();
    }

}
