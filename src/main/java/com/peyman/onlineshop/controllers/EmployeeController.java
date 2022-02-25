package com.peyman.onlineshop.controllers;


import com.peyman.onlineshop.entity.Employee;
import com.peyman.onlineshop.sevice.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EmployeeController {


    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<Page<Employee>> getAll(Pageable pageable){
        Page<Employee> employees = employeeService.findAll(pageable);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("dummy", "dymmy");
        httpHeaders.add(HttpHeaders.CONTENT_LOCATION, "xyz");

        ResponseEntity<Page<Employee>> response = new ResponseEntity<>(employees, httpHeaders , HttpStatus.OK );
        return response;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

}
