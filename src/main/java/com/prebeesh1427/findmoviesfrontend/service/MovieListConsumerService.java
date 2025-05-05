package com.prebeesh1427.findmoviesfrontend.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.prebeesh1427.findmoviesfrontend.data.CountryCode;
import com.prebeesh1427.findmoviesfrontend.dto.MovieSearchResultsDto;

import java.util.List;

@Service
@Slf4j
public class MovieListConsumerService {

	private final RestTemplate restClient;
	private final CountryCode countryCodeList;
	private final String movieNameServiceUrl;

    public MovieListConsumerService(RestTemplate restClient,
									CountryCode countryCodeList,
									@Value("${service.url.movieNameService}") String movieNameServiceUrl) {
        this.restClient = restClient;
        this.countryCodeList = countryCodeList;
		this.movieNameServiceUrl = movieNameServiceUrl;
    }

	public ResponseEntity<MovieSearchResultsDto> getMovieList(String searchText, String countryCode) {
		log.debug("Inside service class");
		if (!StringUtils.hasText(searchText) || !countryCodeList.contains(countryCode)) {
			log.warn("Invalid inputs for movie name and country code");
			return ResponseEntity.badRequest().build();
		}
		String url = String.format("%s%s/%s", movieNameServiceUrl, searchText, countryCode);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(List.of(MediaType.APPLICATION_JSON));
		HttpEntity<String> requestEntity = new HttpEntity<>(headers);
		try {
			log.info("Calling Movies Service API: {}", url);
			return restClient.exchange(url, HttpMethod.GET, requestEntity, MovieSearchResultsDto.class);
		} catch (Exception e) {
			log.error("Exception occurred while calling the API", e);
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
		}
	}
}
