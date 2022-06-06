package com.zensar.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.zensar.bean.Address;
import com.zensar.bean.Student;
import com.zensar.util.JPAUtil;

public class Main3 {
	static void insert() {

		Student student = new Student();
		student.setRollNumber(101);
		student.setName("Azeez");

		Address add = new Address("S-4", "Balaji Nagar", "ATP");
		student.setAddress(add);

		EntityManager em = JPAUtil.createEntityManager("JPAIntro");
		em.getTransaction().begin();

		em.persist(student);
		em.getTransaction().commit();
		JPAUtil.shutDown();
	}

	static void load() {
		EntityManager em = JPAUtil.createEntityManager("JPA_Intro");

		Student student = em.find(Student.class, 100);

		System.out.println(student);
		JPAUtil.shutDown();
	}

	@SuppressWarnings("unchecked")
	static void loadAll() {
		EntityManager em = JPAUtil.createEntityManager("JPA_Intro");

		String qry = "from Student";
		Query query = em.createQuery(qry);
		List<Student> allStudents = query.getResultList();
		System.out.println(allStudents);
		JPAUtil.shutDown();
	}

	static void update() {
		EntityManager em = JPAUtil.createEntityManager("JPA_Intro");
		em.getTransaction().begin();

		Student student = em.find(Student.class, 100);
		student.setName(student.getName().toUpperCase());
		student.getAddress().setCityName("SBC");

		em.merge(student);
		em.getTransaction().commit();
		JPAUtil.shutDown();
	}

	static void delete() {
		EntityManager em = JPAUtil.createEntityManager("JPAIntro");
		em.getTransaction().begin();

		Student student = em.find(Student.class, 100);

		em.remove(student);
		em.getTransaction().commit();
		JPAUtil.shutDown();
	}

	public static void main(String[] args) {
		insert();
		// load();
		// loadAll();
		// update();
		// delete();
	}
}
