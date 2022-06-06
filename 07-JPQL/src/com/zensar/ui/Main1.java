package com.zensar.ui;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import com.zensar.bean.Doctor;
import com.zensar.util.JPAUtil;

public class Main1 {
	public static void main(String[] args) {
		Doctor doctor1 = new Doctor("Santhosh", 500, "MALE", LocalDate.of(2006, 12, 15));
		Doctor doctor2 =new Doctor("Abhi", 1000, "FEMALE", LocalDate.of(2005, 5, 24));
		Doctor doctor3 = new Doctor("Sheela", 800, "FEMALE", LocalDate.of(1998, 2, 20));
		Doctor doctor4 = new Doctor("Vikram", 600, "MALE", LocalDate.of(2018, 6, 18));
		Doctor doctor5 = new Doctor("Ramesh", 850, "MALE", LocalDate.of(2000, 1, 22));

		EntityManager em = JPAUtil.createEntityManager("JPAIntro");
		em.getTransaction().begin();
		em.persist(doctor1);
		em.persist(doctor2);
		em.persist(doctor3);
		em.persist(doctor4);
		em.persist(doctor5);
		em.getTransaction().commit();

		JPAUtil.shutDown();

		System.out.println("Doctor Data Saved ");
	}
}
