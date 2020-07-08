package com.prebeesh1427.findmoviesfrontend.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MoviesDto {

	private String id;
	private String name;
	private String picture;
	@JsonInclude(value = Include.NON_EMPTY)
	private List<MovieLocation> locations = new ArrayList<MovieLocation>();
	@JsonInclude(value = Include.NON_EMPTY)
	private ExternalId external_ids; 
	
	public MoviesDto() {

	}

	public ExternalId getExternal_ids() {
		return external_ids;
	}

	public void setExternal_ids(ExternalId external_ids) {
		this.external_ids = external_ids;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public List<MovieLocation> getLocations() {
		return locations;
	}


	public void setLocations(List<MovieLocation> locations) {
		this.locations = locations;
	}
	
}


