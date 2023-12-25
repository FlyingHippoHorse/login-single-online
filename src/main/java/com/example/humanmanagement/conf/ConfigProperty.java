package com.example.humanmanagement.conf;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Setter
@Getter
@ConfigurationProperties(prefix ="myusr")
public class ConfigProperty {
        private Map<String,String> users;
}