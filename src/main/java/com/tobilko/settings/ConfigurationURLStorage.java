package com.tobilko.settings;

import lombok.Data;

import javax.persistence.*;
import java.net.URL;
import java.util.List;

@Data
@Entity
public class ConfigurationURLStorage {

    @Id
    @GeneratedValue
    private Long id;

    @ElementCollection
    private List<URL> urls;

}
