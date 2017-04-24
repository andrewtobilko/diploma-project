package com.tobilko.settings.encoding.method;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@RequiredArgsConstructor
public enum PasswordEncodingMethod {

    BCRYPT(new BCryptPasswordEncoder()),
    SCRYPT(new SCryptPasswordEncoder()),
    PBKDF2(new Pbkdf2PasswordEncoder());

    @Getter
    private final PasswordEncoder INSTANCE;

}
