package com.tobilko.settings;

import lombok.Data;

import javax.persistence.*;
import java.net.URL;
import java.util.List;

import static javax.persistence.FetchType.*;

@Data
@Entity
public class ConfigurationURLStorage {

    @Id
    @GeneratedValue
    private Long id;

    @ElementCollection(fetch = EAGER)
    private List<URL> urls;

}
