package com.peyman.services;


import com.peyman.data.entities.Users;

public interface UsersService {

	public void addUsers(Users users);
	
	Users findUserByusername(String username);
}
