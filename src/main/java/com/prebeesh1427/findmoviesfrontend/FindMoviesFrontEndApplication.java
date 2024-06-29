package com.prebeesh1427.findmoviesfrontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FindMoviesFrontEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindMoviesFrontEndApplication.class, args);
	}
	
}
