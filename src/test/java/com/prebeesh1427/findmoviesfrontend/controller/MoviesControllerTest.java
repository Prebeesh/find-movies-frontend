package com.prebeesh1427.findmoviesfrontend.controller;

import com.prebeesh1427.findmoviesfrontend.dto.MovieSearchResultsDto;
import com.prebeesh1427.findmoviesfrontend.service.MovieListConsumerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.OK;

@ExtendWith(MockitoExtension.class)
class MoviesControllerTest {

    @Mock
    private MovieListConsumerService movieListConsumerService;

    @InjectMocks
    private MoviesController moviesController;

    @Test
    void givenValidRequest_whenGetMovieLists_thenReturnsResponse() {
        // Given
        String searchText = "Inception";
        String countryCode = "us";
        MovieSearchResultsDto dto = new MovieSearchResultsDto();
        when(movieListConsumerService.getMovieList(searchText, countryCode)).thenReturn(ResponseEntity.ok(dto));

        // When
        ResponseEntity<MovieSearchResultsDto> response = moviesController.getMovieLists(searchText, countryCode);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(OK);
        assertThat(response.getBody()).isEqualTo(dto);
        verify(movieListConsumerService).getMovieList(searchText, countryCode);
    }
} 