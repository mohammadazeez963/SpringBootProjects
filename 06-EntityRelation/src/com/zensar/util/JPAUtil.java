package com.zensar.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private  static EntityManagerFactory emf=null;
    private static EntityManager em=null;

    public static EntityManager createEntityManager(String puName) {
        if(emf==null)
            emf=Persistence.createEntityManagerFactory(puName);

        if(em==null)
            em=emf.createEntityManager();

        return em;

    }


    public static void shutDown() {
        em.close();
        emf.close();
    }
}
