package com.peyman.data;


import com.peyman.data.entities.CustomerContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerContactDao extends JpaRepository<CustomerContact , Long> {





}
