package com.prebeesh1427.findmoviesfrontend.service;

import com.prebeesh1427.findmoviesfrontend.data.CountryCode;
import com.prebeesh1427.findmoviesfrontend.dto.MovieSearchResultsDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieListConsumerServiceTest {

    @Mock
    private RestTemplate restTemplate;
    @Mock
    private CountryCode countryCode;

    private MovieListConsumerService movieListConsumerService;

    @BeforeEach
    void setUp() {
        movieListConsumerService = new MovieListConsumerService(restTemplate, countryCode, "http://localhost:8080/movies");
    }

    @Test
    void givenValidInput_whenGetMovieList_thenReturnsResults() {
        // Given
        String searchText = "Inception";
        String countryCodeStr = "us";
        when(countryCode.contains(countryCodeStr)).thenReturn(true);
        ResponseEntity<MovieSearchResultsDto> expectedResponse = ResponseEntity.ok(new MovieSearchResultsDto());
        when(restTemplate.exchange(
                anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(MovieSearchResultsDto.class)))
                .thenReturn(expectedResponse);

        // When
        ResponseEntity<MovieSearchResultsDto> response = movieListConsumerService.getMovieList(searchText, countryCodeStr);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(restTemplate).exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(MovieSearchResultsDto.class));
    }

    @Test
    void givenInvalidInput_whenGetMovieList_thenReturnsBadRequest() {
        // Given
        String searchText = "";
        String countryCodeStr = "us";

        // When
        ResponseEntity<MovieSearchResultsDto> response = movieListConsumerService.getMovieList(searchText, countryCodeStr);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        verifyNoInteractions(restTemplate);
    }

    @Test
    void givenException_whenGetMovieList_thenReturnsServiceUnavailable() {
        // Given
        String searchText = "Inception";
        String countryCodeStr = "us";
        when(countryCode.contains(countryCodeStr)).thenReturn(true);
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(MovieSearchResultsDto.class)))
                .thenThrow(new RuntimeException("API error"));

        // When
        ResponseEntity<MovieSearchResultsDto> response = movieListConsumerService.getMovieList(searchText, countryCodeStr);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SERVICE_UNAVAILABLE);
    }
} 