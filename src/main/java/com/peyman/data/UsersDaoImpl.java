package com.peyman.data;

import com.peyman.data.entities.Authorities;
import com.peyman.data.entities.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Repository
public class UsersDaoImpl implements UsersDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Users findUserByusername(String username) {
        Users users = (Users) entityManager.createQuery("from Users u where u.username := username")
                .setParameter("username", username).getSingleResult();
        return users;
    }

    @Override
    public void save(Users users) {
        entityManager.persist(users);
        entityManager.close();
    }
}
