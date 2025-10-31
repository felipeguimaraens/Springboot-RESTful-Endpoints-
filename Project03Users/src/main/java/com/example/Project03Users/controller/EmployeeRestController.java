package com.example.Project03Users.controller;

import com.example.Project03Users.dao.EmployeeDAO;
import com.example.Project03Users.entity.Employee;
import com.example.Project03Users.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping()
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
}
