package com.zensar.ui;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.zensar.bean.Employee;
import com.zensar.util.JPAUtil;

public class Main2 {
	
				
				public static void insert() {
					EntityManager em = JPAUtil.createEntityManager("JPAIntro");
					
					Employee emp = new Employee();
					emp.setName("anu");
					emp.setBasic(80000);
					emp.setDateOfJoin(LocalDate.of(2022, 9, 14));
					emp.setGrade('A');
					
					em.getTransaction().begin();
					em.persist(emp);
					em.getTransaction().commit();
					
					JPAUtil.shutDown();
				}
				
				public static void load() {
					EntityManager em = JPAUtil.createEntityManager("JPAIntro");
					
					Employee emp = em.find(Employee.class, 2);
					System.out.println(emp);
					
					JPAUtil.shutDown();
				}
				
				public static void loadAll() {
					EntityManager em = JPAUtil.createEntityManager("JPAIntro");
					
					String s = "from Employee";
					Query qry = em.createQuery(s);
					
					List<Employee>  list  = qry.getResultList();
					list.forEach(System.out::println);
					JPAUtil.shutDown();
				}
				
				public static void edit() {
					EntityManager em = JPAUtil.createEntityManager("JPAIntro");
					
					Employee emp = em.find(Employee.class, 2);
					emp.setBasic(70000);
					
					em.getTransaction().begin();
					em.merge(emp);
					em.getTransaction().commit();
					
					JPAUtil.shutDown();
				}
				
				public static void delete() {
					EntityManager em = JPAUtil.createEntityManager("JPAIntro");
					
					Employee emp = em.find(Employee.class, 1);
					
					
					em.getTransaction().begin();
					em.remove(emp);
					em.getTransaction().commit();
					
					JPAUtil.shutDown();
				}
			
				public static void main(String[] args) {
					loadAll();
				
				}

}
