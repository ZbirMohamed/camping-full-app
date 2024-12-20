package org.example.bookingservice.security;


import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@NoArgsConstructor
public class SecurityConfig {

    @Autowired
    private JwtAuthConverter jwtAuthConverter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .cors(Customizer.withDefaults())
                .csrf(csrf->csrf.disable()) //disabling the csrf since we are using a statless security option
                .headers(h->h.frameOptions(fo->fo.disable())) //let h2-console show the frames
                //permiting the acces to the following path
                .authorizeHttpRequests(ar->ar
                        .requestMatchers("/swagger-ui.html","/swagger-ui/**","/v3/**").permitAll()
                        .requestMatchers(HttpMethod.GET,"/booking").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/booking/{id}").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/booking/{id}").hasAuthority("ADMIN")
                )
                //making sure that all the other paths require auth
                .authorizeHttpRequests(ar->ar.anyRequest().authenticated())
                .oauth2ResourceServer(o2-> o2.jwt( jwt-> jwt.jwtAuthenticationConverter(jwtAuthConverter) ))
            .build();
    }
    //Cors Configuration to give acces to all browsers
    //If you use an api gateway you must add it s own configuration
    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setExposedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);
        return source;
    }

}
