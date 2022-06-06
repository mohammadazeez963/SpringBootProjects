package com.zensar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.bean.Employee;
import com.zensar.db.EmployeeDAO;

@Service
public class EmployeeService {
			@Autowired
			EmployeeDAO dao;
			
			public List<Employee> getAllEmployees() {
				return dao.findAll();
			}
			
			public Employee getEmployeeById(int id) {
				Optional<Employee> optional = dao.findById(id);
				if (optional.isPresent()) {
					return optional.get();
				} 
				return null;
				
				
			}
			
			public Employee addEmployee(Employee employee) {
				   	return dao.save(employee);
			}
			
			public Employee editEmployee(Employee employee) {
				 	return dao.save(employee);
			}
			
			public boolean removeEmployee(Employee employee) {
					dao.delete(employee);
					return true;
			}
}	
