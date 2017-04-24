package com.tobilko.settings.authentication;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class AuthenticationConfigurationController {

    private final AuthenticationConfigurationService service;

    @ResponseStatus(CREATED)
    @PutMapping("/api/authentication/modify")
    public void putAuthenticationConfiguration(@RequestBody AuthenticationConfiguration update) {
        service.putAuthenticationConfiguration(update);
    }

}