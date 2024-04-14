package com.greatlearning.ems.service;

import java.util.List;

import com.greatlearning.ems.entity.Employee;

public interface EmployeeService {

	List<Employee> employeeList();

	void employeeSave(Employee employee);

	Employee employeeFindById(int employeeId);

	void deleteEmployeeById(int employeeId);

}
