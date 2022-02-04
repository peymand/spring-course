package com.peyman.data;

import com.peyman.data.entities.Users;
import org.springframework.stereotype.Repository;



public interface UsersDao{

	Users findUserByusername(String username);

	public void save(Users users);
}
