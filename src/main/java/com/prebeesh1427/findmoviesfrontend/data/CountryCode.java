package com.prebeesh1427.findmoviesfrontend.data;

import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CountryCode {

	private final Set<String> countryCodes = Stream.of(
			"in", "us", "uk", "ar", "at", "au", "be", "br", "ca", "ch", "cz", "dk", "de", "ee", "es", "fr", "hk",
			"hu", "ie", "il", "is", "it", "jp", "kr", "lt", "lv", "mx", "nl", "no", "nz", "ph", "pl", "pt", "ro",
			"ru", "se", "sg", "sk", "th", "za"
	).collect(Collectors.toUnmodifiableSet());
	
	public boolean contains(String code) {
		return countryCodes.contains(code);
	}
}
