package com.kayal.employeejpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kayal.employeejpa.model.Employee;
import com.kayal.employeejpa.model.Telephone;
import com.kayal.employeejpa.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee employee) {
		
		for(Telephone telephone: employee.getTelephone()) {
			telephone.setEmployee(employee);
		}
		return employeeService.createEmployee(employee);
	}
}
