package com.tobilko.settings.cors;

import com.tobilko.settings.ConfigurationState;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
public class CORSConfigurationController {

    private final CORSConfigurationService service;

    @ResponseStatus(CREATED)
    @PutMapping("/api/cors/modify")
    public void putCORSConfiguration(@RequestBody CORSConfiguration update) {
        service.putCORSConfiguration(update);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/api/cors/remove-url")
    public void removeSpecificURLForActiveState(@RequestParam String url,
                                                @RequestParam ConfigurationState state) {
        service.removeSpecificURLForActiveState(url, state);
    }

}
