package com.prebeesh1427.findmoviesfrontend.restController;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prebeesh1427.findmoviesfrontend.dto.MovieSearchResultsDto;
import com.prebeesh1427.findmoviesfrontend.service.MovieListConsumer;

@RestController
public class MovieListProvider {
	
	@Autowired
	private MovieListConsumer movieListConsumer;
	
	Logger logger = LoggerFactory.getLogger(MovieListProvider.class);

	//@ResponseBody
	@GetMapping(path = "movieList/{searchText}/{countryCode}")
	public ResponseEntity<MovieSearchResultsDto> getMovieLists(@PathVariable("searchText") String movieName, @PathVariable("countryCode") String countryCode) {
		logger.debug("Inside controller - MovieListProvider");
		return movieListConsumer.getMovieList(movieName, countryCode);
		//logger.debug("Sending the response from controller to client");
		//return new ResponseEntity<MovieSearchResultsDto> (response.getBody(),HttpStatus.OK);
	}
}
