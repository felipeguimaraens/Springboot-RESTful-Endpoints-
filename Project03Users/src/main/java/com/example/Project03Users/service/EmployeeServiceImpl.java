package com.example.Project03Users.service;

import com.example.Project03Users.dao.EmployeeDAO;
import com.example.Project03Users.dao.EmployeeDAOJpaImpl;
import com.example.Project03Users.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeDAO) {
        employeeDAO = theEmployeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
