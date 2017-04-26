package io.sahka.consul;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestEndpoint {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${key}")
    private String key;

    @Value("${env:uknown}")
    private String env;

    @RequestMapping("/consul-info")
    public String consulInfo() {
        List<String> res = new ArrayList<>();
        List<ServiceInstance> list = discoveryClient.getInstances("STORES");
        if (list != null && list.size() > 0) {
            res.add(list.get(0).getUri().toString());
        }
        return StringUtils.join(res, "; ");
    }

    @RequestMapping("/")
    public String home() {
        return "Hello world" + appName + " Key: " + key + " env: " + env;
    }
}
