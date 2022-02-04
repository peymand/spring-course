package com.peyman.data;


import com.peyman.data.entities.Authorities;
import org.springframework.stereotype.Repository;



public interface AuthoritiesDao{

	Authorities findAuthoritiesByusername(String username);
	void save(Authorities authorities);
}
