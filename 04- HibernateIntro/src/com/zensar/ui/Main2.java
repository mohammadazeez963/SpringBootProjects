package com.zensar.ui;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zensar.bean.Employee;
import com.zensar.util.HibernateUtil;

public class Main2 {
				public static void insert() {
					Employee employee = new Employee();
					employee.setName("naveen");
					employee.setDateOfJoin(LocalDate.of(2021, 4,14));
					employee.setBasic(30000.00);
					employee.setGrade('B');
					
					HibernateUtil.init();
					Session session = HibernateUtil.getSession();
					
					Transaction tx = session.beginTransaction();
					session.save(employee);
					tx.commit();
					
					HibernateUtil.cleanUp();
				}

				public static void load() {
					HibernateUtil.init();
					Session session = HibernateUtil.getSession();
					
					Employee employee = session.load(Employee.class, 2);
					System.out.println(employee);
					HibernateUtil.cleanUp();
				}
				
				public static void loadAll() {
					HibernateUtil.init();
					Session session = HibernateUtil.getSession();
					
					String qry = "from Employee";
					Query query = session.createQuery(qry);
					List<Employee> list = query.list();
					
					list.forEach(System.out::println);
					HibernateUtil.cleanUp();
					
				}
				
				public static void edit() {
					HibernateUtil.init();
					Session ses = HibernateUtil.getSession();
					
					Employee  emp = ses.load(Employee.class, 2);
					emp.setBasic(100000);
					
					Transaction tx = ses.beginTransaction();
					ses.update(emp);
					tx.commit();
					
					HibernateUtil.cleanUp();
				}
				
				public static void delete() {
					HibernateUtil.init();
					Session session = HibernateUtil.getSession();
					
					Employee emp = session.load(Employee.class, 3);
					
					Transaction tx = session.beginTransaction();
					session.delete(emp);
					tx.commit();
					
					HibernateUtil.cleanUp();
							
					
				}
				
				public static void main(String[] args) {
					loadAll();
					
				}

}
