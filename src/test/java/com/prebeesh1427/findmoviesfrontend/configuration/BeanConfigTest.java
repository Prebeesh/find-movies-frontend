package com.prebeesh1427.findmoviesfrontend.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

class BeanConfigTest {

    @Test
    void whenRestTemplateBean_thenNotNull() {
        // Given
        BeanConfig config = new BeanConfig();

        // When
        RestTemplate restTemplate = config.restTemplate();

        // Then
        assertThat(restTemplate).isNotNull();
    }
} 