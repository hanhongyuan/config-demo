package io.sahka.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulClientTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulClientTwoApplication.class, args);
	}
}
