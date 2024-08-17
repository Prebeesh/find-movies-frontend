package com.prebeesh1427.findmoviesfrontend.service;

import org.springframework.http.ResponseEntity;

import com.prebeesh1427.findmoviesfrontend.dto.MovieSearchResultsDto;

public interface MovieListConsumer {

	ResponseEntity<MovieSearchResultsDto> getMovieList(String searchText, String countryCode);
}
