package com.interviewDOT.actuatorDemo;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "customFeatures")
public class CustomFeatureEndpoint {

    private Map<String, Object> features = new ConcurrentHashMap<>();

    @ReadOperation
    public Map<String, Object> customFeatues(){
        features.put("customFeature", "sample custom metric from the application");
        return features;
    }
}

