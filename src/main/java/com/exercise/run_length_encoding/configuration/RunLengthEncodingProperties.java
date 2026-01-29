package com.exercise.run_length_encoding.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "run-length-encoding")
public record RunLengthEncodingProperties(RunLengthEncodingImplementation implementation) {}