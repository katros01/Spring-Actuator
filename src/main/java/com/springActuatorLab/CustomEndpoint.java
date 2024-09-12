package com.springActuatorLab;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "customEndpoint")
public class CustomEndpoint {

    private final Map<String, String> customData = new HashMap<>();

    @ReadOperation
    public Map<String, String> readCustomData() {
        customData.put("username", "admin");
        customData.put("email", "admin@test.com");
        return customData;
    }

    @WriteOperation
    public String writeCustomData(@Selector String key, String value) {
        customData.put(key, value);
        return "Data added successfully";
    }
}

