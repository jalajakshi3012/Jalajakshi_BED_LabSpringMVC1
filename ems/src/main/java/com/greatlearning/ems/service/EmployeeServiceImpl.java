package com.greatlearning.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.ems.entity.Employee;
import com.greatlearning.ems.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	//View all records from the database table.
	@Override
	public List<Employee> employeeList() {
		return employeeRepo.findAll();
	}
	
	// Insert new records into the table
	@Override
	public void employeeSave(Employee employee) {
		employeeRepo.save(employee);
	}
	
	@Override
	public Employee employeeFindById(int employeeId) {
		Optional<Employee> employee = employeeRepo.findById(employeeId);
		return employee.get();
	}
	
	//Delete existing records from the table.
	@Override
	public void deleteEmployeeById(int employeeId) {

		employeeRepo.deleteById(employeeId);
	}

}
