package com.example.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Employee;
import com.example.demo.persistance.EmployeeService;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {

	private final EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeRepository) {
		this.employeeService = employeeRepository;
	}

	@GetMapping
	public List<Employee> getEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("{name}")
	public Employee getEmployeeByName(@PathVariable String name) {
		return employeeService.findEmployeeByName(name);
	}

	@PostMapping
	public void addEmployee(Employee employee) {
		employeeService.saveEmployee(employee);
	}
}
