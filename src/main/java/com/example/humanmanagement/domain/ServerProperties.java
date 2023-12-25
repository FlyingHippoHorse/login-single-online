package com.example.humanmanagement.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "server")
public class ServerProperties {

    private Map<String, String> application;
    private Map<String, List<String>> config;
    private Map<String, Credential> users;

    // getters and setters

    @Setter
    @Getter
    public static class Credential {
    	
        private String username;
        private String password;
        
        // getters and setters
        
    }
}