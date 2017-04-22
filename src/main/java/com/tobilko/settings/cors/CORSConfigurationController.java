package com.tobilko.settings.cors;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CORSConfigurationController {

    private final CORSConfigurationService service;

    @PutMapping("/api/cors/modify")
    @ResponseStatus(HttpStatus.CREATED)
    public void putCORSConfiguration(@RequestBody CORSConfiguration update) {
        service.putCORSConfiguration(update);
    }

}
