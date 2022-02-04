package com.peyman.data;

import com.peyman.data.entities.Authorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class AuthoritiesDaoImpl implements AuthoritiesDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Authorities findAuthoritiesByusername(String username) {
        Authorities authorities = (Authorities) entityManager.createQuery("from Authorities a where a.username := username")
                .setParameter("username", username).getSingleResult();
        return authorities;
    }

    @Override
    public void save(Authorities authorities) {
        entityManager.persist(authorities);
        entityManager.close();
    }
}
