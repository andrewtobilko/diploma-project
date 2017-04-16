package com.tobilko.settings.cors;

import com.tobilko.settings.Configuration;
import com.tobilko.settings.ConfigurationState;
import com.tobilko.settings.ConfigurationURLStorage;
import lombok.Data;

import javax.persistence.*;
import java.net.URL;
import java.util.List;
import java.util.Map;

import static javax.persistence.CascadeType.*;

@Data
@Table(name = "cors")
@Entity(name = "cors")
public class CORSConfiguration implements Configuration {

    @Id
    @GeneratedValue
    private Long id;

    private boolean enabled;

    @OneToMany(cascade = {PERSIST, REMOVE})
    private Map<ConfigurationState, ConfigurationURLStorage> map;

}
