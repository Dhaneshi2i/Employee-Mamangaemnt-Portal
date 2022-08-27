/*
 * <p>
 *   Copyright (c) All rights reserved
 * </p>
 */

package com.ideas2it.employee.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

public class EmployeeDaoImpl<T extends Employee> implements IEmployeeDao<T> {   

    private T value;

    public EmployeeDaoImpl(T value) {
	this.value = value;
    }

    @Override
    public void insertEmployee(T employee) {    

        try (Session session = HibernateUtility.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> retriveAllEmployees() {     

	if ( value instanceof Trainee) {

            List<Trainee> trainees = new ArrayList<>();
            try (Session session = HibernateUtility.getSession()) {
                Transaction transaction = session.beginTransaction();
	        Criteria criteria = session.createCriteria(Trainee.class);
	        criteria.add(Restrictions.eq("deleted", false));
                trainees = criteria.list();
                transaction.commit();
            } catch (HibernateException e) {
                e.printStackTrace();
            } 
            return (List<T>)trainees;
                
	} else {
            List<Trainer> trainers = new ArrayList<>();
            try (Session session = HibernateUtility.getSession()) {
                Transaction transaction = session.beginTransaction();
	        Criteria criteria = session.createCriteria(Trainer.class);
	        criteria.add(Restrictions.eq("deleted", false));
                trainers = criteria.list();
                transaction.commit();
            } catch (HibernateException e) {
                e.printStackTrace();
            }
            return (List<T>)trainers;
	}
    }

    @Override
    public T retriveEmployeeById(int id) {

	if (value instanceof Trainee) {

            Trainee selectedTrainee = null;
            try (Session session = HibernateUtility.getSession()) {
                Transaction transaction = session.beginTransaction();

                Trainee trainee = (Trainee) session.get(Trainee.class, id);	
                selectedTrainee = trainee;
                session.update(selectedTrainee);
                transaction.commit();
            } catch (HibernateException e) {
                e.printStackTrace();
	    }
	    return (T)selectedTrainee;
	} else {

            Trainer selectedTrainer = null;
            try (Session session = HibernateUtility.getSession()) {
                Transaction transaction = session.beginTransaction();

                Trainer trainer = (Trainer) session.get(Trainer.class, id);	
                selectedTrainer = trainer;
                session.update(selectedTrainer);
                transaction.commit();
            } catch (HibernateException e) {
                e.printStackTrace();
	    }
	    return (T)selectedTrainer;
	}
    }

    @Override
    public String removeEmployeeById(Employee employee) {

        String deletionMessage = "Didn't delete the Employee";
        try (Session session = HibernateUtility.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
            deletionMessage = "Employee deleted";               
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return deletionMessage;
    }

    @Override
    public String updateEmployeeById(Employee employee) {

        String updationMessage = "Trainee details not updated";
        try (Session session = HibernateUtility.getSession()) {
            Transaction transaction = session.beginTransaction();   
            session.update(employee);
            transaction.commit();
            updationMessage  = "Trainee details successfully updated";
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return updationMessage; 
    }  
}

    /*@Override
    public String employeeAssociation(int employeeId, List<T> employeesId) {

	if (value instanceof Trainee) {
	
            String message = "Associated failed";
            try (Session session = HibernateUtility.getSession()) {
                Transaction transaction = session.beginTransaction();	
                Criteria criteria = session.createCriteria(Trainee.class);
                criteria.add(Restrictions.eq("deleted", false));
                List<Trainee> trainees = criteria.list();
                for (Trainee trainee : trainees) {
                    if (trainee.getId().equals(employeeId)) {
                        trainee.setTrainer((List<Trainer>) employeesId);
                    }
                }
                transaction.commit();
                message = "Trainers to trainee successfully associated";
            } catch (HibernateException e) {
                e.printStackTrace();
            }
            return message;

	} else {

            String message = "Associated failed";
            try (Session session = HibernateUtility.getSession()) {
                Transaction transaction = session.beginTransaction();
                Criteria criteria = session.createCriteria(Trainer.class);
                criteria.add(Restrictions.eq("deleted", false));
                List<Trainer> trainers = criteria.list();
                for (Trainer trainer : trainers) {
                    if (trainer.getId().equals(employeeId)) {
                        trainer.setTrainee((List<Trainee>) employeesId);
                    }
                }	
                transaction.commit();
                message = "Trainees to trainer successfully associated";
            } catch (HibernateException e ) {
                e.printStackTrace();
            }
            return message;         
	} 
    }*/   

    /*@Override
    public List<Employee> retrieveAndDisplayAssociatedEmployee(int id) {

	if (value instanceof Trainee) {
            List<Employee> employees = new ArrayList<>();
	    try (Session session = HibernateUtility.getSession()) {
                Transaction transaction = session.beginTransaction();
                Criteria criteria = session.createCriteria(Trainee.class);
                criteria.add(Restrictions.eq("deleted", false));
                List<Trainee> trainees = criteria.list();
                for (Trainee trainee : trainees) {
                    if (trainee.getId().equals(id)) {
                        employees.add(trainee);
                        for (Trainer trainer : trainee.getTrainer()) {
                            employees.add(trainer);
                        }
                    }   
	        }
                transaction.commit();
	    } catch (HibernateException e ) {
		e.printStackTrace();
	    }
	    return (List<Employee>) employees;

	} else {

            List<Employee> employees = new ArrayList<>();
	    try (Session session = HibernateUtility.getSession()) {
                Transaction transaction = session.beginTransaction();
                Criteria criteria = session.createCriteria(Trainer.class);
                criteria.add(Restrictions.eq("deleted", false));
                List<Trainer> trainers = criteria.list();
                for (Trainer trainer : trainers) {
                    if (trainer.getId().equals(id)) {
                        employees.add(trainer);
                        for (Trainee trainee : trainer.getTrainee()) {
                            employees.add(trainee);
                        }
                    }   
	        }
                transaction.commit();
	    } catch (HibernateException e ) {
		e.printStackTrace();
            }
            return (List<Employee>) employees;
	}
    }*/
