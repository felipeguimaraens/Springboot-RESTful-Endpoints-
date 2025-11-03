package com.example.Project03Users.controller;

import com.example.Project03Users.dao.EmployeeDAO;
import com.example.Project03Users.entity.Employee;
import com.example.Project03Users.request.EmployeeRequest;
import com.example.Project03Users.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name="Employee Rest API Endpoints", description = "Operations related to employees.")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @Operation(summary = "Get all employees", description = "Retrieve a list of all employees.")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @Operation(summary = "Get single employee", description = "Get a single employee from database.")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable @Min(value = 1) long employeeId) {
        return employeeService.findById(employeeId);
    }

    @Operation(summary = "Add new employee", description = "Add a new employee to database.")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Employee addEmployee(@Valid @RequestBody EmployeeRequest theEmployee){
        return employeeService.save(theEmployee);
    }

    @Operation(summary = "Update single employee", description = "Update a single employee from database.")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable @Min(value=1) long employeeId,
                                   @Valid @RequestBody EmployeeRequest employeeRequest){
        return employeeService.update(employeeId, employeeRequest);
    }

    @Operation(summary = "Delete single employee", description = "Delete a employee from database.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable @Min(value=1) long employeeId){
        employeeService.deleteById(employeeId);
    }
}
