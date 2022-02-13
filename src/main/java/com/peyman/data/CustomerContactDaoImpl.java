package com.peyman.data;

import com.peyman.data.entities.CustomerContact;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomerContactDaoImpl implements CustomerContactDao {
    @Override
    public void addNewMessage(CustomerContact customerContact) {

    }

    @Override
    public void deleteMessageById(long customerContactId) {

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

    }

    @Override
    public void delete(long customerContactId) {

    }

    @Override
    public List<CustomerContact> findAll() {
        return null;
    }
}
