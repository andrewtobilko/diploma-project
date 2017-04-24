package com.tobilko.settings.encoding;

import com.tobilko.settings.ConfigurationState;
import com.tobilko.settings.encoding.method.PasswordEncodingMethod;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;

@Data
@Table(name = "encoding")
@Entity(name = "encoding")
public class PasswordEncodingConfiguration {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(STRING)
    private ConfigurationState state;

    @Enumerated(STRING)
    private PasswordEncodingMethod method;

}