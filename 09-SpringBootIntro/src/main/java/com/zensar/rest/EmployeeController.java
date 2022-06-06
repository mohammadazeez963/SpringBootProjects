package com.zensar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.bean.Employee;
import com.zensar.service.EmployeeService;

@RestController
public class EmployeeController {
			@Autowired
			EmployeeService service;
			
			@PostMapping(value = "/add")
			public Employee f1(@RequestBody Employee employee) {
				return  this.service.addEmployee(employee);
			}
			@GetMapping(value = "/getAll")
			public List<Employee> f2(){
			return this.service.getAllEmployees();
			}

			@GetMapping(value ="/findEmp/{eid}")
			public Employee f3(@PathVariable(name ="eid")int id) {
			return this.service.getEmployeeById(id);
			}
			@PutMapping(value ="/update")
			public Employee f4(@RequestBody Employee employee) {
			return this.service.editEmployee(employee);
			}

			@DeleteMapping(value ="/delete")
			public boolean f5(@RequestBody Employee employee) {
			return this.service.removeEmployee(employee);
			}
}
