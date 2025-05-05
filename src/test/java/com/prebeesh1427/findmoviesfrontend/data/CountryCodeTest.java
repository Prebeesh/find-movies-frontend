package com.prebeesh1427.findmoviesfrontend.data;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CountryCodeTest {

    @Test
    void givenValidCode_whenContains_thenReturnsTrue() {
        // Given
        CountryCode countryCode = new CountryCode();

        // When
        boolean result = countryCode.contains("us");

        // Then
        assertThat(result).isTrue();
    }

    @Test
    void givenInvalidCode_whenContains_thenReturnsFalse() {
        // Given
        CountryCode countryCode = new CountryCode();

        // When
        boolean result = countryCode.contains("xx");

        // Then
        assertThat(result).isFalse();
    }
} 