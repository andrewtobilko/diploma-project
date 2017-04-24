package com.tobilko.settings.encoding;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
public class PasswordEncodingConfigurationController {

    private final PasswordEncodingConfigurationService service;

    @ResponseStatus(CREATED)
    @PutMapping(path = "/api/password-encoding/modify")
    public void modifyPasswordEncodingConfiguration(@RequestBody PasswordEncodingConfiguration configuration) {
        service.modifyPasswordEncodingConfiguration(configuration);
    }

}
