package com.prebeesh1427.findmoviesfrontend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieLocation {
	private String icon;
	private String id;
	private String displayName;
	private String name;
	private String url;
}