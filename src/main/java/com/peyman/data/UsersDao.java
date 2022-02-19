package com.peyman.data;

import com.peyman.data.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersDao extends JpaRepository<Users, Long> {

	Users findUserByusername(String username);

}
