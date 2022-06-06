package com.zensar.ui;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;


import com.zensar.bean.Person;
import com.zensar.util.HibernateUtil;


public class Main1 {
					    static void insert() {
				        Person person=new Person();
				        person.setName("Naveen");
				        person.setSalary(60000.00);
				
				        Session session=null;
				        HibernateUtil.init();
				        session=HibernateUtil.getSession();
				
				        Transaction tx=session.beginTransaction();
				
				        session.save(person);
				
				        tx.commit();
				
				        HibernateUtil.cleanUp();
				
				
				       }
					    
					public static void load() {
						Person person = null;
						Session session = null;
						HibernateUtil.init();
						session = HibernateUtil.getSession();
						
						person = session.load(Person.class, 2);
						System.out.println(person);
				        HibernateUtil.cleanUp();

					}
					
					public static void loadAll() {
						Session session = null;
						HibernateUtil.init();
						session = HibernateUtil.getSession();
						
						String qry  =  "from Person";
						Query query = session.createQuery(qry);
						List<Person> allPersons = query.list();
						allPersons.forEach(System.out::println);
						
				        HibernateUtil.cleanUp();

					}
					
					public static void editing() {
						HibernateUtil.init();
						Session session = HibernateUtil.getSession();
						
						Person person = session.load(Person.class, 2);
						person.setSalary(100000);
						
						Transaction tnx = session.beginTransaction();
						session.update(person);
						tnx.commit();
						
						HibernateUtil.cleanUp();
					}
					
					public static void deleting() {
						HibernateUtil.init();
						Session session = HibernateUtil.getSession();
						
						Person person =  session.load(Person.class, 3);
						
						Transaction tnx = session.beginTransaction();
						session.delete(person);
						tnx.commit();
						HibernateUtil.cleanUp();
					}
					    
					
					 public static void main(String[] args) {
						
						  loadAll();
					      
					 }


}
