package com.example.demo.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Employee;
import com.example.demo.domain.QEmployee;
import com.querydsl.jpa.JPQLTemplates;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

@Service
public class EmployeeService {
	private final EmployeeRepository employeeRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	public void saveEmployee(Employee employee) {
		if(employee.getAge() > 20) {
			employeeRepository.save(employee);
		}
	}

	public Employee findEmployeeByName(String name) {
		JPAQueryFactory queryFactory = new JPAQueryFactory(JPQLTemplates.DEFAULT, entityManager);
		QEmployee employee = QEmployee.employee;
		return queryFactory.selectFrom(employee).where(employee.firstName.eq(name)).fetchOne();
	}
}
