package com.prebeesh1427.findmoviesfrontend.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class MoviesDtoTest {

    @Test
    void givenMoviesDto_whenSettersAndGetters_thenWorks() {
        // Given
        MoviesDto dto = new MoviesDto();
        dto.setId("1");
        dto.setName("Inception");
        dto.setPicture("pic.jpg");

        // When & Then
        assertThat(dto.getId()).isEqualTo("1");
        assertThat(dto.getName()).isEqualTo("Inception");
        assertThat(dto.getPicture()).isEqualTo("pic.jpg");
    }
} 