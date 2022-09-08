/*
 * <p>
 *   Copyright (c) All rights reserved
 * </p>
 */

package com.ideas2it.employee.service;

import com.ideas2it.employee.dao.IEmployeeDao;
import com.ideas2it.employee.dao.impl.EmployeeDaoImpl;
import com.ideas2it.employee.dto.EmployeeDto;
import com.ideas2it.employee.service.impl.EmployeeServiceImpl;

import java.util.List;

public interface IEmployeeService <T extends EmployeeDto> {

    /**
     * <p>
     *   used to add Employee into List
     * </p>
     * 
     * @param employee {@link T} the employee object 
     * 
     * @return {@link void}
     * 
     */
    public void createEmployee(T t);

    /**
     * <p>
     *   Returns list of all employees
     * </p>
     * 
     * @return {@link List} of {@link T}
     * 
     */
    public List<T> getAllEmployees();

    /**
     * <p>
     *   used to get employee by his id
     * </p>
     * 
     * @param employeeId {@link String} id of employee 
     * 
     * @return {@link T} the employee object
     * 
     */
    public T getEmployeeById(String id);

    /**
     * <p>
     *   used to remove the Employee by his id
     * </p>
     * 
     * @param employeeId {@link String} id of employee 
     * 
     * @return {@link String} deletion message
     * 
     */
    public String deleteEmployeeById(String id);

    /**
     * <p>
     *   used to update the Employee by his id
     * </p>
     * 
     * @param id {@link String} id of employee 
     *
     * @param mobileNumber{@link long} mobile number of employee
     * 
     * @return {@link String} the updation message
     * 
     */
    public String updateEmployeeById(String id, Long contactNumber);

    /**
     * <p>
     *   used to associate the employees by their id
     * </p>
     * 
     * @param employees {@link List} of {@link T} list of employees 
     * 
     * @param employeeId {@link String} id of employee
     *
     * @return {@link String} the updation message
     * 
     */
    public void association(String employeeId, List<T> employeesDto);

    /**
     * <p>
     *   used to get associated employees with id
     * </p>
     * 
     * @param id {@link String} id of employee 
     * 
     * @return {@link List} of {@link EmployeeDto}
     * 
     */
    public List<EmployeeDto> getAssociatedEmployeeDetails(String id);
}


    