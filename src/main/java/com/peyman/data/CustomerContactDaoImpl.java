package com.peyman.data;

import com.peyman.data.entities.CustomerContact;
import com.peyman.data.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class CustomerContactDaoImpl implements CustomerContactDao {

    @Autowired
    SessionFactory sessionFactory;

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void addNewMessage(CustomerContact customerContact) {

    }

    @Override
    public void deleteMessageById(long customerContactId) {
        CustomerContact customerContact = entityManager.find(CustomerContact.class, customerContactId);
        entityManager.remove(customerContact);
        entityManager.flush();
    }

    @Override
    public List<CustomerContact> getAllCustomerContact() {
        return null;
    }

    @Override
    public List<CustomerContact> getAllCustomerMessage(Integer pageNumber) {
        return null;
    }

    @Override
    public void save(CustomerContact customerContact) {
        Session session = sessionFactory.openSession();
        session.save(customerContact);

        session.close();
    }

    @Override
    public void delete(long customerContactId) {
        CustomerContact customerContact = entityManager.find(CustomerContact.class, customerContactId);
        entityManager.remove(customerContact);
        entityManager.flush();

    }

    @Override
    public List<CustomerContact> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query from_customerContact = session.createQuery("from CustomerContact");
            List<CustomerContact> list = from_customerContact.list();
            return list;
        }
    }


}
