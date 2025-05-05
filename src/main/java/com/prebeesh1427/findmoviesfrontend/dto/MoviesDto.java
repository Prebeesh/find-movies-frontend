package com.prebeesh1427.findmoviesfrontend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@Data
@NoArgsConstructor
public class MoviesDto {
	private String id;
	private String name;
	private String picture;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<MovieLocation> locations;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private ExternalId externalIds;
}


