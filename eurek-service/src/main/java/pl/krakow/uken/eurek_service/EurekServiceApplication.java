package pl.krakow.uken.eurek_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaServer
public class EurekServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekServiceApplication.class, args);
	}

	@LoadBalanced
	@Bean
	RestTemplate restTemplate(){return new RestTemplate();}

}
