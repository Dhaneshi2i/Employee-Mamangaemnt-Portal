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
 *   Implemented to create a new employee or search, update and delete
 *   existing employee 
 * </p>
 *
 * <p>  
 *   This file is created on 27/07/2022
 *   @author : Dhanesh Kumar
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
    public List<T> retrieveAllEmployees();

    /**
     * <p>
     *   Retrieve employee with his id
     * </p>
     * 
     * @param id {@link int} id of employee
     * 
     * @return {@link T} the employee object
     * 
     */
    public T retrieveEmployeeById(String id);

    /**
     * <p>
     *   update employee with his id
     * </p>
     * 
     * @param employee {@link employee} the employee object
     * 
     * @return {@link String} updation message 
     * 
     */
    public String updateEmployee(Employee employee);
}
     
