package com.peyman.onlineshop.sevice;

import com.peyman.onlineshop.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

    Page<Employee> findAll(Pageable pageable);

    void save(Employee employee);
}
