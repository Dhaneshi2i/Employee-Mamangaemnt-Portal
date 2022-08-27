package com.ideas2it.employee.dao;

import java.util.List;
import com.ideas2it.employee.dao.impl.EmployeeDaoImpl;
import com.ideas2it.employee.entity.Employee;
import com.ideas2it.employee.entity.Trainee;
import com.ideas2it.employee.entity.Trainer;


public interface IEmployeeDao<T extends Employee> {

    public void insertEmployee(T employeeObject);

    public List<T> retriveAllEmployees();

    public T retriveEmployeeById(String id);

    public String removeEmployeeById(String id);

    public String updateEmployeeById(String id, Long contactNumber);

    public String employeeAssociation(String employeeId, String employeesId);

    public List<Employee> retrieveAndDisplayAssociatedEmployee(String id);
}
     
