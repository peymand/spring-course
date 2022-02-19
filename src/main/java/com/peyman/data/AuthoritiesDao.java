package com.peyman.data;


import com.peyman.data.entities.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthoritiesDao extends JpaRepository<Authorities , Long>{

	Authorities findAuthoritiesByusername(String username);
}
