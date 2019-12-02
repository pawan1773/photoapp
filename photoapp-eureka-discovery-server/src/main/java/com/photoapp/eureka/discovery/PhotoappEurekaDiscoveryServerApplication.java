package com.photoapp.eureka.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PhotoappEurekaDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoappEurekaDiscoveryServerApplication.class, args);
	}

}
