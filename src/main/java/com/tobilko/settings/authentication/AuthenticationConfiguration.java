package com.tobilko.settings.authentication;

import com.tobilko.settings.ConfigurationState;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;

@Data
@Table(name = "authentication")
@Entity(name = "authentication")
public class AuthenticationConfiguration {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(STRING)
    private ConfigurationState state;

}
