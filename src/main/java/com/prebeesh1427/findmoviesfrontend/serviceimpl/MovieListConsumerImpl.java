package com.prebeesh1427.findmoviesfrontend.serviceimpl;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.prebeesh1427.findmoviesfrontend.data.CountryCode;
import com.prebeesh1427.findmoviesfrontend.dto.MovieSearchResultsDto;
import com.prebeesh1427.findmoviesfrontend.service.MovieListConsumer;

@Service
public class MovieListConsumerImpl implements MovieListConsumer{

	private static final Logger logger = LoggerFactory.getLogger(MovieListConsumerImpl.class);
	private final RestTemplate restClient;
	private final CountryCode countryCodeList;
	private final String movieNameServiceUrl;

	public MovieListConsumerImpl(@Value("${service.url.movieNameService}") String movieNameServiceUrl,
								 CountryCode countryCodeList,
								 RestTemplate restClient) {
		this.movieNameServiceUrl = movieNameServiceUrl;
		this.countryCodeList = countryCodeList;
		this.restClient = restClient;
	}
	
	@Override
	public ResponseEntity<MovieSearchResultsDto> getMovieList(String searchText, String countryCode) {

		logger.debug("Inside service class");
		if(isInValid(searchText, countryCode)) {
			logger.error("Server side validation failed. Invalid inputs for movie name and country code");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		String url = prepareUrl(searchText, countryCode);
		HttpHeaders header = new HttpHeaders();
		prepareHeader(header);
		HttpEntity<String> requestEntity = new HttpEntity<String>(header);
		try {
			logger.info("Calling Movies Service Api");
			return restClient.exchange(url,
					HttpMethod.GET,
					requestEntity,
					MovieSearchResultsDto.class);
		}catch (Exception e) {
			logger.error("Exception occurred while calling the API: "+ e.getMessage());
			return new ResponseEntity<>(
			          HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	private boolean isInValid(String searchText, String countryCode) {
		if(StringUtils.hasText(searchText) && countryCodeList.contains(countryCode)) {
			return false;
		}
		return true;
	}

	private String prepareUrl(String searchText, String countryCode) {
		return movieNameServiceUrl+searchText+"/"+countryCode;
	}

	private void prepareHeader(HttpHeaders header) {
		logger.debug("Setting the Headers");
		header.setContentType(MediaType.APPLICATION_JSON);
		header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
	}

}
