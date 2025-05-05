package com.prebeesh1427.findmoviesfrontend.controller;

import com.prebeesh1427.findmoviesfrontend.dto.MovieSearchResultsDto;
import com.prebeesh1427.findmoviesfrontend.service.MovieListConsumerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MoviesController {

    private final MovieListConsumerService movieListConsumer;

    @GetMapping("/movieList/{searchText}/{countryCode}")
    public ResponseEntity<MovieSearchResultsDto> getMovieLists(
            @PathVariable String searchText,
            @PathVariable String countryCode) {
        log.info("Received request for getMovieLists({}, {})", searchText, countryCode);
        return movieListConsumer.getMovieList(searchText, countryCode);
    }
}
