package com.ua.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
  private static final SessionFactory sessionFactory = buildSessionFactory();

  private static SessionFactory buildSessionFactory(){
    try {
      Configuration configuration = new Configuration();
      configuration.configure("hibernate.cfg.xml");

      ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
        .applySettings(configuration.getProperties()).build();

     return configuration.buildSessionFactory(serviceRegistry);
    } catch (Throwable e){
     throw new ExceptionInInitializerError(e);
    }
  }

  public static SessionFactory getSessionFactory(){
    return sessionFactory;
  }

  public static void shutdown(){
    sessionFactory.close();
  }
}
