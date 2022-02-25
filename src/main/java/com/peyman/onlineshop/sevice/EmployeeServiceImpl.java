package com.peyman.onlineshop.sevice;

import com.peyman.onlineshop.entity.Employee;
import com.peyman.onlineshop.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    @Override
    public Page<Employee> findAll(Pageable pageable) {

        return employeeRepository.findAll(pageable);
    }

    @Transactional
    @Modifying
    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
}
