package com.ideas2it.employee.service;

import com.ideas2it.employee.dao.IEmployeeDao;
import com.ideas2it.employee.dao.impl.EmployeeDaoImpl;
import com.ideas2it.employee.dto.EmployeeDto;
import com.ideas2it.employee.service.impl.EmployeeServiceImpl;

import java.util.List;

public interface IEmployeeService <T extends EmployeeDto> {

    public void createEmployee(T t);

    public List<T> getAllEmployees();

    public T getEmployeeById(int id);

    public String deleteEmployeeById(int id);

    public String updateEmployeeById(int id, Long contactNumber);

    //public String association(int employeeId, List<T> employeesId);

    //public List<EmployeeDto> getAssociatedEmployeeDetails(String id);

}


    