package com.zensar.bean.pack1;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name = "persons10")
public class Person {
	@Id
	@Column
	
	private int personId;
	
	@Column
	private String personName;
	
	@Column
	private LocalDate dateOfBirth;
	
	@Column
	private char gender;
	
    @OneToOne(mappedBy = "person",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	private ContactInfo contactInfo;
    
    @OneToOne(mappedBy = "person",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	private  Salary salary;
	
	public Person(String personName, LocalDate dateOfBirth, char gender) {
		super();
		this.personName = personName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}
	
	


	public Person() {
		super();
	}




	public int getPersonId() {
		return personId;
	}


	public void setPersonId(int personId) {
		this.personId = personId;
	}


	public String getPersonName() {
		return personName;
	}


	public void setPersonName(String personName) {
		this.personName = personName;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public ContactInfo getContactInfo() {
		return contactInfo;
	}


	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	
	


	public Salary getSalary() {
		return salary;
	}




	public void setSalary(Salary salary) {
		this.salary = salary;
	}




	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", contactInfo=" + contactInfo + ", salary=" + salary + "]";
	}




	
	
	
	
}
