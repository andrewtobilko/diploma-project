//package com.tobilko.configuration.global.auth.provider;
//
//import com.tobilko.user.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//
//@Component
//@RequiredArgsConstructor
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//    private final String ADMIN_LOGIN = "admin";
//    private final String ADMIN_PASSWORD = "admin";
//
//    private final UserRepository repository;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//
//        String name = authentication.getName();
//        String password = authentication.getCredentials().toString();
//
//        if (ADMIN_LOGIN.equals(name) && ADMIN_PASSWORD.equals(password)) {
//            // log and skip
//        } else {
//            repository
//                    .findByLogin(name)
//                    .orElseThrow(() -> new UsernameNotFoundException("User with that login couldn't be found!"));
//        }
//
//        return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//
//}