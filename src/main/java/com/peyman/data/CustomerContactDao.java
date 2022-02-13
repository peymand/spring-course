package com.peyman.data;


import com.peyman.data.entities.CustomerContact;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerContactDao {
    public void addNewMessage(CustomerContact customerContact);

    public void deleteMessageById(long customerContactId);

    public List<CustomerContact> getAllCustomerContact();


    List<CustomerContact> getAllCustomerMessage(Integer pageNumber);

    void save(CustomerContact customerContact);

    void delete(long customerContactId);

    List<CustomerContact> findAll();
}
