/*
 * <p>
 *   Copyright (c) All rights reserved
 * </p>
 */

package com.ideas2it.employee.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.NoResultException;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.HibernateException;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.Transaction;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.ideas2it.employee.dao.IEmployeeDao;
import com.ideas2it.employee.entity.Employee;
import com.ideas2it.employee.entity.Trainee;
import com.ideas2it.employee.entity.Trainer;
import com.ideas2it.employee.util.HibernateUtility;

/**
 * <p>
 *   Implemented to create a new employee or search, update, and delete
 *   existing employee 
 * </p>
 *
 * <p>  
 *   This file is created on 27/07/2022
 *   @author : Dhanesh Kumar
 * </p>
 */
public class EmployeeDaoImpl<T extends Employee> implements IEmployeeDao<T> {   

    private T value;

    public EmployeeDaoImpl(T value) {
	this.value = value;
    }

    private static Logger logger = Logger.getLogger(EmployeeDaoImpl.class);

    //private static Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    /**
     * <p>
     *   Insert an employee to the list  
     * </p>
     *
     * @param employee {@link T} the employee object 
     *
     */
    @Override
    public void insertEmployee(T employee) {    

        try (Session session = HibernateUtility.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            if (employee instanceof Trainee) {
                session.persist((Trainee)employee);
            } else {
                session.persist((Trainer)employee);
            }
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("",e);
        }
    }

    /**
     * <p>
     *   Retrieve list of all employees
     * </p>
     *
     * @return {@link List} of {@link T}
     */
    @Override
    public List<T> retrieveAllEmployees() {

        List<Employee> employees = new ArrayList<>();
        try (Session session = HibernateUtility.getInstance().getSession()) {
            if ( value instanceof Trainee) {
                TypedQuery query = session.getNamedQuery("get_all_trainees");
                query.setParameter("isActiveEmployee", false);
                employees = query.getResultList();
            } else {
                TypedQuery query = session.getNamedQuery("get_all_trainers");
                query.setParameter("isActiveEmployee", false);
                employees = query.getResultList();
            }
        } catch (HibernateException e) {
            logger.error("",e);
        } 
        return (List<T>)employees;                
    }

    /**
     * <p>
     *   Retrieve employee with his id
     * </p>
     * 
     * @param id {@link String} id of employee 
     * 
     * @return {@link T} the employee object
     * 
     */
    @Override
    public T retrieveEmployeeById(String id) {
            
        Employee employee = null;
        try (Session session = HibernateUtility.getInstance().getSession()) {
            if (value instanceof Trainee) {
                Query query = session.getNamedQuery("get_trainee_by_id");
                query.setParameter("isActiveEmployee",false);
                query.setParameter("id", id);
                Trainee trainee = (Trainee) query.getSingleResult();
                employee = trainee;
            } else {
                Query query = session.getNamedQuery("get_trainer_by_id");
                query.setParameter("isActiveEmployee", false);
                query.setParameter("id", id);
                Trainer trainer = (Trainer) query.getSingleResult();
                employee = trainer;
            }
        } catch (NoResultException e) {
            logger.error("",e);          
	}
	return (T)employee;
    }

    /**
     * <p>
     *   update employee with his id
     * </p>
     * 
     * @param employee {@link employee} the employee object
     * 
     * @return {@link String} updated message
     * 
     */
    @Override
    public String updateEmployee(Employee employee) {

        String updatedMessage = "Employee details not updated";
        try (Session session = HibernateUtility.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction(); 

            if (employee instanceof Trainee) { 
                session.update((Trainee)employee);
            } else {
                session.update((Trainer)employee);
            }
            transaction.commit();
            updatedMessage  = "Employee details successfully updated";
        } catch (HibernateException e) {
            logger.error("",e);
        }
        return updatedMessage;
    }  
}
