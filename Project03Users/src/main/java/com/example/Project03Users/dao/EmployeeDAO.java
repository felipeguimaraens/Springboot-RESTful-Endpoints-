package com.example.Project03Users.dao;

import com.example.Project03Users.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
