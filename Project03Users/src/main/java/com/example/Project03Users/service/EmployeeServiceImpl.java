package com.example.Project03Users.service;

import com.example.Project03Users.dao.EmployeeDAO;
import com.example.Project03Users.dao.EmployeeDAOJpaImpl;
import com.example.Project03Users.entity.Employee;
import com.example.Project03Users.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public Employee findById(long theId) {
        return employeeDAO.findById(theId);
    }

    @Transactional
    @Override
    public Employee save(EmployeeRequest employeeRequest) {
        Employee theEmployee = convertToEmployee(0, employeeRequest);
        return employeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public Employee update(long id, EmployeeRequest employeeRequest) {
        Employee theEmployee = convertToEmployee(id, employeeRequest);
        return employeeDAO.save(theEmployee);
    }

    @Override
    public Employee convertToEmployee(long id, EmployeeRequest employeeRequest) {
        return new Employee();
    }

    @Transactional
    @Override
    public void deleteById(long theId) {
        employeeDAO.deleteById(theId);
    }
}
