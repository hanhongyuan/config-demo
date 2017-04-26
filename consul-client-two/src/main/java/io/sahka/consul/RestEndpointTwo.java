package io.sahka.consul;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestEndpointTwo {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${key}")
    private String key;

    @Value("${env:uknown}")
    private String env;

    @RequestMapping("/")
    public String home() {
        return "Hello world" + appName + " Key: " + key + " env: " + env;
    }
}
