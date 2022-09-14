package com.ideas2it.employee.util;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;

import com.ideas2it.employee.entity.Trainee;
import com.ideas2it.employee.entity.Trainer;

/**
 * <p>
 *   Implemented to establish database connection 
 * </p>
 *
 * <p>  
 *   This file is created on 27/07/2022
 *   @author : Dhanesh Kumar
 * </p>
 */
public class HibernateUtility {

    private static HibernateUtility hibernateUtility; 
    private static Session session = null;

    private HibernateUtility() {

        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            configuration.addAnnotatedClass(Trainee.class);
            configuration.addAnnotatedClass(Trainer.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);   
            session = sessionFactory.openSession();
        } catch(HibernateException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>
     *   used to get the connection object 
     * <p>
     *
     * @return hibernateUtility {@link HibernateUtility} the hibernateUtility object
     *
     */
    public static HibernateUtility getInstance() {
    
        if (session == null || !session.isOpen()) {
            hibernateUtility = new HibernateUtility();
        }
        return hibernateUtility;
    }

    /**
     * <p>
     *   used to get the session 
     * <p>
     *
     * @return session {@link Session} the session object
     *
     */
    public Session getSession(){
        return session;
    }
}

