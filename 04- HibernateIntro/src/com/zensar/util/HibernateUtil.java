package com.zensar.util;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
 
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static Session session;

    public static void init() {
        ServiceRegistry registry;
        registry = new StandardServiceRegistryBuilder().configure().build();
        MetadataSources metaSources = new MetadataSources(registry);
        Metadata metaData = metaSources.getMetadataBuilder().build();
        sessionFactory = metaData.getSessionFactoryBuilder().build();
        session=sessionFactory.openSession();
    }

    public static Session getSession() {
        return session;
    }

    public static void cleanUp() {
        session.close();
        sessionFactory.close();
    }
 
}
