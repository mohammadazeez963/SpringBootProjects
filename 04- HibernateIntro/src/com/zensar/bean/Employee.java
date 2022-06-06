package com.zensar.bean;

import java.time.LocalDate;

public class Employee {
	private int empId;
	private String name;
	private LocalDate dateOfJoin;
	private double basic;
	private  char grade;
	
	
	public Employee(int empId, String name, LocalDate dateOfJoin, double basic, char grade) {
		super();
		this.empId = empId;
		this.name = name;
		this.dateOfJoin = dateOfJoin;
		this.basic = basic;
		this.grade = grade;
	}


	public Employee() {
		super();
	}

// getter and setter
	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getDateOfJoin() {
		return dateOfJoin;
	}


	public void setDateOfJoin(LocalDate dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}


	public double getBasic() {
		return basic;
	}


	public void setBasic(double basic) {
		this.basic = basic;
	}


	public char getGrade() {
		return grade;
	}


	public void setGrade(char grade) {
		this.grade = grade;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", dateOfJoin=" + dateOfJoin + ", basic=" + basic
				+ ", grade=" + grade + "]";
	}
	
	
	
	

}
