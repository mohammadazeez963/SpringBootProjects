package com.zensar.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.bean.Employee;
@Repository  //DAO --> data access object

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
