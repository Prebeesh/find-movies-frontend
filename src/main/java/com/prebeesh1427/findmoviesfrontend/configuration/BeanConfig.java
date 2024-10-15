package com.prebeesh1427.findmoviesfrontend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

	@Bean
	public RestTemplate getRestClient() {
		return new RestTemplate();
	}
}
