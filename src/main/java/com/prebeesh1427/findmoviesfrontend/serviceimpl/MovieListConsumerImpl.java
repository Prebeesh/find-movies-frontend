package com.prebeesh1427.findmoviesfrontend.serviceimpl;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prebeesh1427.findmoviesfrontend.data.CountryCode;
import com.prebeesh1427.findmoviesfrontend.dto.MovieSearchResultsDto;
import com.prebeesh1427.findmoviesfrontend.service.MovieListConsumer;

@Service
public class MovieListConsumerImpl implements MovieListConsumer{

	@Autowired
	private RestTemplate restClient;
	
	@Autowired
	private CountryCode countryCodeList;
	
	@Value("${MovieNameService.url}")
	private String MovieNameServiceUrl;
	
	Logger logger = LoggerFactory.getLogger(MovieListConsumerImpl.class);
	
	@Override
	public ResponseEntity<MovieSearchResultsDto> getMovieList(String searchText, String countryCode) {
		
		logger.debug("Inside service class");
		
		if(validateInput(searchText, countryCode)) {
			logger.error("*****************************");
			logger.error("Server side validation failed");
			logger.error("*****************************");
			return new ResponseEntity<MovieSearchResultsDto>(HttpStatus.BAD_REQUEST);
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
			logger.error("******************************************");
			logger.error("Exception occured while calling the API "+ e);
			logger.error("******************************************");
			return new ResponseEntity<MovieSearchResultsDto>(
			          HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	private boolean validateInput(String searchText, String countryCode) {

		if(searchText == "" || searchText == null || !countryCodeList.contains(countryCode)) {
			return true;
		}
		return false;
	}

	private String prepareUrl(String searchText, String countryCode) {
		
		return MovieNameServiceUrl+searchText+"/"+countryCode;
	}

	private void prepareHeader(HttpHeaders header) {
		
		logger.debug("Setting the Header");
		header.setContentType(MediaType.APPLICATION_JSON);
		header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
	}

}
