package com.peyman.data.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authorities {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long authoritiesId;
	
	private String username;
	
	private String authorityType;

	
	
	
	
}
