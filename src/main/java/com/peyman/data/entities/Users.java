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
public class Users {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long usersId;
	
	private String username;
	
	private String password;
	
	private boolean enabled;
	
	private long customerId;

	
	
	
	
	
}
