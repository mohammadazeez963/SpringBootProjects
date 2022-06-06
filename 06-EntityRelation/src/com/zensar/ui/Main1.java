package com.zensar.ui;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import com.zensar.bean.pack1.ContactInfo;
import com.zensar.bean.pack1.Person;
import com.zensar.bean.pack1.Salary;
import com.zensar.util.JPAUtil;

public class Main1 {
	static void test1(){
		Person person = new Person("param",LocalDate.of(2013, 5, 10), 'M');
		person.setPersonId(1011);
		
		ContactInfo contactInfo = new ContactInfo("azeezmdpl@gmail.com", "9676423422");
		Salary salary = new Salary(40000.00, 20000.00, 38000.00);
		
		person.setContactInfo(contactInfo);
		 contactInfo.setPerson(person);
		 
		person.setSalary(salary);
		salary.setPerson(person);
	   
	    
	    EntityManager em = JPAUtil.createEntityManager("JPAIntro");
	    em.getTransaction().begin();
	    em.persist(person);
	    em.getTransaction().commit();
	    
	    
	   JPAUtil.shutDown();
		
	}
	
	public static void test2() {
		EntityManager em = JPAUtil.createEntityManager("JPAIntro");
		
		Person person = em.find(Person.class, 1001);
		System.out.println(person);
	}
	
	public static void test3() {
		EntityManager em = JPAUtil.createEntityManager("JPAIntro");
		
		ContactInfo contactInfo = em.find(ContactInfo.class, 1001);
		System.out.println(contactInfo);
		System.out.println(contactInfo.getPerson());

		JPAUtil.shutDown();
	}
	public static void main(String[] args) {
		test1();
	}
}
