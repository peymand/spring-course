package com.peyman.services;


import com.peyman.data.entities.Authorities;

public interface AuthoritiesService {

	void addAuthorities(Authorities authorities);
	
	Authorities findAuthoritiesByusername(String username);
}
