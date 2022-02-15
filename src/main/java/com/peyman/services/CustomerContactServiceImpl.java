package com.peyman.services;


import com.peyman.data.CustomerContactDao;
import com.peyman.data.entities.CustomerContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class CustomerContactServiceImpl implements CustomerContactService {

	private static final int PAGE_ELEMENT_SIZE=10;
	
	@Autowired
	private CustomerContactDao customerContactDao;
	@Transactional()
	@Override
	public void addNewMessage(CustomerContact customerContact) {
		
		customerContactDao.save(customerContact);
		
	}
	@Transactional()
	@Override
	public void deleteMessageById(long customerContactId) {
		
		customerContactDao.delete(customerContactId);
	}
	@Transactional(readOnly = true)
	@Override
	public List<CustomerContact> getAllCustomerContact() {
		
		return (List<CustomerContact>) customerContactDao.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public List<CustomerContact> getAllCustomerMessage(Integer pageNumber) {
		return customerContactDao.findAll();
	}

	}
