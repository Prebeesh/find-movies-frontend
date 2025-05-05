package com.prebeesh1427.findmoviesfrontend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class MovieSearchResultsDto {
	private List<MoviesDto> results;
}
