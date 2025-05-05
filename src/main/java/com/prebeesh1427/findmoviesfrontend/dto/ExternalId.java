package com.prebeesh1427.findmoviesfrontend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExternalId {
	private IdAndUrl imdb;
	private IdAndUrl tmdb;
	private IdAndUrl wikiData;

	@Data
	@NoArgsConstructor
	public static class IdAndUrl {
		private String url;
		private String id;
	}
}

