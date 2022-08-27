package com.ideas2it.employee.service;

import com.ideas2it.employee.dao.IEmployeeDao;
import com.ideas2it.employee.dao.impl.EmployeeDaoImpl;
import com.ideas2it.employee.dto.EmployeeDto;
import com.ideas2it.employee.service.impl.EmployeeServiceImpl;

import java.util.List;

public interface IEmployeeService <T extends EmployeeDto> {

    public void createEmployee(T t);

    public List<T> getAllEmployees();

    public T getEmployeeById(String id);

    public String deleteEmployeeById(String id);

    public String updateEmployeeById(String id, Long contactNumber);

    public String association(String employeeId, List<T> employeesId);

    public List<EmployeeDto> getAssociatedEmployeeDetails(String id);

}


    