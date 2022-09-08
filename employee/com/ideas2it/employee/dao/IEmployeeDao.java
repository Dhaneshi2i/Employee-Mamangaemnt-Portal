/*
 * <p>
 *   Copyright (c) All rights reserved
 * </p>
 */

package com.ideas2it.employee.dao;

import java.util.List;
import com.ideas2it.employee.dao.impl.EmployeeDaoImpl;
import com.ideas2it.employee.entity.Employee;
import com.ideas2it.employee.entity.Trainee;
import com.ideas2it.employee.entity.Trainer;

/**
 * <p>
 *   Implementation to save a new employee and to search, update, and delete
 *   existing employee details in the database 
 * </p>
 *
 * <p>  
 *   This file is created on 27/07/2022
 *   @author : Dhanesh kumar
 * </p>
 */
public interface IEmployeeDao<T extends Employee> {          

    /**
     * <p>
     *   Insert an employee to the database  
     * </p>
     *
     * @param employee {@link T} the employee object 
     * 
     * @return {@link void}
     */
    public void insertEmployee(T employee);

    /**
     * <p>
     *   Retrieve all employees
     * </p>
     *
     * @return {@link List} of {@link Employee}
     */
    public List<T> retriveAllEmployees();

    /**
     * <p>
     *   Retrive employee with his id
     * </p>
     * 
     * @param Id {@link int} id of employee
     * 
     * @return {@link T} the employee object
     * 
     */
    public T retriveEmployeeById(String id);

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
    public String removeEmployeeById(Employee employee);

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
    public String updateEmployee(Employee employee);

    public void updateEmployeeAssociation(Employee employee);

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
    public List<Employee> retrieveAndDisplayAssociatedEmployee(String id);
}
     
