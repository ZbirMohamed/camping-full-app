package org.example.bookingservice.config;

import org.example.bookingservice.security.JwtAuthConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConverterConfig {
    @Bean
    public JwtAuthConverter jwtAuthConverter() {
        return new JwtAuthConverter();
    }
}
