//package com.tobilko.configuration.global;
//
//import com.tobilko.settings.cors.CORSConfigurationRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//@Configuration
//@RequiredArgsConstructor
//public class GlobalCORSConfiguration {
//
//    private final String ALL = "*";
//    private final String TRUSTED_ORIGIN = "http://localhost:4200";
//
//    private final CORSConfigurationRepository corsConfigurationRepository;
//
////    @Bean
////    public FilterRegistrationBean corsFilter() {
////        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////
////        CorsConfiguration config = new CorsConfiguration();
////
////        corsConfigurationRepository.findFirstBy().ifPresent(corsConfiguration -> {
//////            addTrustedOrigins(config);
//////            if (corsConfiguration.getState() == ENABLED) {
//////                List<String> urls = corsConfiguration.getMap().get(ENABLED).getUrls();
//////
//////                urls.forEach(config::addAllowedOrigin);
////            //} else {
////                config.addAllowedOrigin(ALL);
////            //}
////
////            addTrustedOrigins(config);
////            config.setAllowCredentials(true);
////            config.addAllowedHeader(ALL);
////            config.addAllowedMethod(ALL);
////        });
////
////        source.registerCorsConfiguration("/**", config);
////        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
////        bean.setOrder(0);
////
////        return bean;
////    }
//
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//
//        CorsConfiguration config = new CorsConfiguration();
//
//        config.addAllowedOrigin(ALL);
//        //config.setAllowCredentials(true);
//        config.addAllowedHeader(ALL);
//        config.addAllowedMethod(ALL);
//
//        return new CorsFilter(source);
//    }
//
//    private void addTrustedOrigins(CorsConfiguration configuration) {
//        configuration.addAllowedOrigin(TRUSTED_ORIGIN);
//    }
//
//}
