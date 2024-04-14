package com.greatlearning.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.greatlearning.ems.entity.Employee;
import com.greatlearning.ems.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/employee-list")
	public String employeesList(Model model) {
		List<Employee> employees = employeeService.employeeList();
		model.addAttribute("employees", employees);
		return "list-employees";
	}

	@RequestMapping("/showEmployeeForm_Save")
	public String addnewEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "add-new-employee";
	}

	@RequestMapping("/save")
	public String saveemployee(@ModelAttribute("employee") Employee employee) {
		employeeService.employeeSave(employee);
		return "redirect:/employee/employee-list";
	}

	@RequestMapping("/showEmployeeForm_Update")
	public String updateEmployee_Step1(@RequestParam("employeeId") int employeeId, Model theModel) {
		Employee employee = employeeService.employeeFindById(employeeId);
		theModel.addAttribute("employee", employee);
		return "add-new-employee";
	}

	@RequestMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") int employeeId, Model theModel) {
		employeeService.deleteEmployeeById(employeeId);
		return "redirect:/employee/employee-list";

	}

}
