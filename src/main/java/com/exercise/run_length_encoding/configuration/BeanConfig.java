package com.exercise.run_length_encoding.configuration;

import com.exercise.run_length_encoding.service.RunLengthEncodingRegexServiceImpl;
import com.exercise.run_length_encoding.service.RunLengthEncodingService;
import com.exercise.run_length_encoding.service.RunLengthEncodingServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RunLengthEncodingProperties.class)
public class BeanConfig {

    @Bean
    public RunLengthEncodingService sortingService(RunLengthEncodingProperties properties) {
        return switch (properties.implementation()) {
            case SIMPLE -> new RunLengthEncodingServiceImpl();
            case REGEX -> new RunLengthEncodingRegexServiceImpl();
        };
    }
}
