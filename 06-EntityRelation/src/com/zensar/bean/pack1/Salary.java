package com.zensar.bean.pack1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salaryInfo")
public class Salary {
	@Id
	@Column
		int empId;
	@Column
		double grossSalary;
	@Column
		double deductions;
	@Column
		double netSalary;
	
	 @OneToOne
     @MapsId
     @JoinColumn(name="person_id")
	private Person person;



	public Salary() {
		super();
	}

	public Salary(double d, double e, double f) {
		this.grossSalary = d;
		this.deductions = e;
		this.netSalary = f;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}

	public double getDeductions() {
		return deductions;
	}

	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}

	public double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Salary [empId=" + empId + ", grossSalary=" + grossSalary + ", deductions=" + deductions + ", netSalary="
				+ netSalary + "]";
	}
	 
	 
		
		
}
