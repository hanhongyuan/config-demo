package io.sahka.serviceone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
public class RestToTestClientBalancingEndpoint {

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private Registration registration;

    @Autowired
    private Configuration.SampleClient sampleClient;

    @Autowired
    private RestTemplate restTemplate;

    private final String appName = "consul-client";

    @RequestMapping("/services")
    public List<String> services() {
        return discoveryClient.getServices();
    }

    @RequestMapping("/me")
    public String me() {
        return registration.getServiceId();
    }

    @RequestMapping("/")
    public ServiceInstance lb() {
        return loadBalancer.choose(appName);
    }

    @RequestMapping("/root")
    public String root() {
        return this.restTemplate.getForObject("http://"+appName+"/", String.class);
    }

    @RequestMapping("/choose")
    public String choose() {
        return loadBalancer.choose(appName).getUri().toString();
    }

    @RequestMapping("/instances")
    public List<ServiceInstance> instances() {
        return discoveryClient.getInstances(appName);
    }

    @RequestMapping("/feign")
    public String feign() {
        return sampleClient.choose();
    }
}
