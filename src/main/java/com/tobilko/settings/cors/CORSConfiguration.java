package com.tobilko.settings.cors;

import com.tobilko.settings.Configuration;
import com.tobilko.settings.ConfigurationState;
import com.tobilko.settings.ConfigurationURLStorage;
import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.EnumType.*;
import static javax.persistence.FetchType.*;

@Data
@Table(name = "cors")
@Entity(name = "cors")
public class CORSConfiguration implements Configuration {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(STRING)
    private ConfigurationState state;

    @OneToMany(cascade = {PERSIST, MERGE, REMOVE}, fetch = EAGER)
    private Map<ConfigurationState, ConfigurationURLStorage> map;

    public CORSConfiguration() {
        map = new HashMap<>();
    }

}
