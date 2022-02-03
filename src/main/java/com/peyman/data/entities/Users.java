package com.peyman.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
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
