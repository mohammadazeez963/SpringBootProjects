package com.zensar.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.zensar.bean.Person;

public class Main1 {
	
					    static void insert() {
				        				EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAIntro");
				        				EntityManager em = emf.createEntityManager();
				        				
				        				Person person = new Person();
				        				person.setName("naveen");
				        				person.setSalary(50000);
				        				
				        				em.getTransaction().begin();
				        				em.persist(person);
				        				em.getTransaction().commit();
				        				
				        				em.close();
				        				emf.close();
				      				
				       }
					    
					    public static void load() {
					    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAIntro");
	        				EntityManager em = emf.createEntityManager();
	        				
	        				Person person = em.find(Person.class, 1);
	        				System.out.println(person);
	        				
	        				em.close();
	        				emf.close();
						}
				
					    public static void loadAll() {
					    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAIntro");
	        				EntityManager em = emf.createEntityManager();
	        				
	        				String query = "from Person";
	        				Query qry = em.createQuery(query);
	        				List<Person>  list= qry.getResultList();
	        				 
	        				list.forEach(System.out::println);
	        				
	        				em.close();
	        				emf.close();
	        				
						}
					    
					    public static void edit() {
					    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAIntro");
	        				EntityManager em = emf.createEntityManager();
	        				
	        			    Person person = em.find(Person.class, 5);
	        			    person.setSalary(120000);
	        			    
	        			    em.getTransaction().begin();
	        			    em.merge(person);
	        			    em.getTransaction().commit();
	        			    
	        			    em.close();
	        			    emf.close();
						}
					    
					    public static void delete() {
					    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAIntro");
	        				EntityManager em = emf.createEntityManager();
	        				
	        			    Person person = em.find(Person.class, 4);
	        				        			    
	        			    em.getTransaction().begin();
	        			    em.remove(person);
	        			    em.getTransaction().commit();
	        			    
	        			    em.close();
	        			    emf.close();
						}
					
					 public static void main(String[] args) {
						
						  edit();
					      
					 }


}
