/*
 * <p>
 *   Copyright (c) All rights reserved
 * </p>
 */

package com.ideas2it.employee.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.HibernateException; 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.Transaction;

import com.ideas2it.employee.dao.IEmployeeDao;
import com.ideas2it.employee.entity.Employee;
import com.ideas2it.employee.entity.Trainee;
import com.ideas2it.employee.entity.Trainer;
import com.ideas2it.employee.util.HibernateUtility;

/**
 * <p>
 *   Implementation to save a new employee and to search, update, and delete
 *   existing employee details to the database
 * </p>
 *
 * <p>  
 *   This file is created on 27/07/2022
 *   @author : Dhanesh kumar
 * </p>
 */
public class EmployeeDaoImpl<T extends Employee> implements IEmployeeDao<T> {   

    private T value;

    public EmployeeDaoImpl(T value) {
	this.value = value;
    }

    private static Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    /**
     * <p>
     *   Insert an employee to the list  
     * </p>
     *
     * @param employee {@link T} the employee object 
     * 
     * @return {@link void}
     */
    @Override
    public void insertEmployee(T employee) {    

        try (Session session = HibernateUtility.getSession()) {
            Transaction transaction = session.beginTransaction();
            if (employee instanceof Trainee) {
                session.save(employee);
            } else {
                session.save(employee);
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
    public List<T> retriveAllEmployees() {     

        List<Employee> employees = new ArrayList<>();
        try (Session session = HibernateUtility.getSession()) {
            Transaction transaction = session.beginTransaction();
            if ( value instanceof Trainee) {
	        Criteria criteria = session.createCriteria(Trainee.class);
	        criteria.add(Restrictions.eq("isActiveEmployee", false));
                employees = criteria.list();
            } else {
                Criteria criteria = session.createCriteria(Trainer.class);
	        criteria.add(Restrictions.eq("isActiveEmployee", false));
                employees = criteria.list();
            }
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("",e);
        } 
        return (List<T>)employees;                
    }

    /**
     * <p>
     *   Retrive employee with his id
     * </p>
     * 
     * @param id {@link String} id of employee 
     * 
     * @return {@link T} the employee object
     * 
     */
    @Override
    public T retriveEmployeeById(String id) {
            
        Employee employee = null;
        try (Session session = HibernateUtility.getSession()) {
            Transaction transaction = session.beginTransaction();

            if (value instanceof Trainee) {
                Criteria criteria = session.createCriteria(Trainee.class);
	        criteria.add(Restrictions.eq("id", id));
                criteria.add(Restrictions.eq("isActiveEmployee",false));
                List<Trainee> trainees = criteria.list();
                for (Trainee trainee : trainees) {
                    if (trainee.getId().equals(id)) {
                        employee = trainee;
                        break;
                    }
                }
            } else {
                Criteria criteria = session.createCriteria(Trainer.class);
	        criteria.add(Restrictions.eq("id", id));
                criteria.add(Restrictions.eq("isActiveEmployee",false));
                List<Trainer> trainers = criteria.list();
                for (Trainer trainer : trainers) {
                    if (trainer.getId().equals(id)) {
                        employee = trainer;
                        break;
                    }
                }
            }
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("",e);
	}
	return (T)employee;
    }

    /**
     * <p>
     *   Delete employee with his id
     * </p>
     * 
     * @param Id {@link int} id of employee
     * 
     * @return {@link String} deletion message 
     * 
     */
    @Override
    public String removeEmployeeById(Employee employee) {

        String deletionMessage = "Didn't delete the Employee";
        try (Session session = HibernateUtility.getSession()) {
            Transaction transaction = session.beginTransaction();
            if (employee instanceof Trainee) {
                session.update(employee);
            } else {
                session.update(employee);
            }
            transaction.commit();
            deletionMessage = "Employee deleted";               
        } catch (HibernateException e) {
            logger.error("",e);
        }
        return deletionMessage;
    }

    /**
     * <p>
     *   update employee with his id
     * </p>
     * 
     * @param Employee {@link employee} the employee object
     * 
     * @return {@link String} updation message 
     * 
     */
    @Override
    public String updateEmployee(Employee employee) {

        String updationMessage = "Employee details not updated";
        try (Session session = HibernateUtility.getSession()) {
            Transaction transaction = session.beginTransaction(); 

            if (employee instanceof Trainee) { 
                session.update((Trainee)employee);
            } else {
                session.update((Trainer)employee);
            }
            transaction.commit();
            updationMessage  = "Employee details successfully updated";
        } catch (HibernateException e) {
            logger.error("",e);
        }
        return updationMessage; 
    }  

    @Override
    public void updateEmployeeAssociation(Employee employee) {

        //String updationMessage = "Employee details not updated";
        try (Session session = HibernateUtility.getSession()) {
            Transaction transaction = session.beginTransaction(); 

            if (employee instanceof Trainee) { 
                session.update((Trainee)employee);
            } else {
                session.update((Trainer)employee);
            }
            transaction.commit();
            //updationMessage  = "Employee details successfully updated";
        } catch (HibernateException e) {
            logger.error("",e);
        }
        //return updationMessage; 
    }

    /**
     * <p>
     *   retrive associated employee details
     * </p>
     * 
     * @param id {@link String} id of employee
     * 
     * @return {@link List} of {@Link employee}
     * 
     */
    @Override
    public List<Employee> retrieveAndDisplayAssociatedEmployee(String id) {

	
        List<Employee> employees = new ArrayList<>();
        try (Session session = HibernateUtility.getSession()) {
            Transaction transaction = session.beginTransaction();
            if (value instanceof Trainee) {
                Criteria criteria = session.createCriteria(Trainee.class);
                criteria.add(Restrictions.eq("isActiveEmployee", false));
                List<Trainee> trainees = criteria.list();
                for (Trainee trainee : trainees) {
                    if (trainee.getId().equals(id)) {
                        employees.add(trainee);
                        for (Trainer trainer : trainee.getTrainer()) {
                            employees.add(trainer);
                        }
                    }   
	        }
           } else {
                Criteria criteria = session.createCriteria(Trainer.class);
                criteria.add(Restrictions.eq("isActiveEmployee", false));
                List<Trainer> trainers = criteria.list();
                for (Trainer trainer : trainers) {
                    if (trainer.getId().equals(id)) {
                        employees.add(trainer);
                        for (Trainee trainee : trainer.getTrainee()) {
                            employees.add(trainee);
                        }
                    }   
	        }
            }
            transaction.commit();
        } catch (HibernateException e ) {
	    logger.error("",e);
	}
        return (List<Employee>) employees;
    }
}
