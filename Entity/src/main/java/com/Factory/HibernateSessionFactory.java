package com.Factory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


/**
 * Created by Roman on 05.07.2017.
 */
public class HibernateSessionFactory {

    protected static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try{
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }catch (Exception e){
//            StandardServiceRegistryBuilder.destroy(registry);
            throw new ExceptionInInitializerError("Initial SessionFactory failed" + e);
        }

        return sessionFactory;
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void close(){
        getSessionFactory().close();
    }
}
