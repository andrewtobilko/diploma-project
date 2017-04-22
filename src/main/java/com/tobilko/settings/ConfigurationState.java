package com.tobilko.settings;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ConfigurationState {

    ENABLED("ENABLED"),
    DISABLED("DISABLED");

    private final String value;

    @Override
    public String toString() {
        return value;
    }

}
