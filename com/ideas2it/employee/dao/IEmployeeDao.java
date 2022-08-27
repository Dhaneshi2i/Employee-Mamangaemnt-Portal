package com.ideas2it.employee.dao;

import java.util.List;
import com.ideas2it.employee.dao.impl.EmployeeDaoImpl;
import com.ideas2it.employee.entity.Employee;
import com.ideas2it.employee.entity.Trainee;
import com.ideas2it.employee.entity.Trainer;


public interface IEmployeeDao<T extends Employee> {

    public void insertEmployee(T employee);

    public List<T> retriveAllEmployees();

    public T retriveEmployeeById(int id);

    public String removeEmployeeById(Employee employee);

    public String updateEmployeeById(Employee employee);

    //public String employeeAssociation(int employeeId, List<T> employeesId);

    //public List<Employee> retrieveAndDisplayAssociatedEmployee(int id);
}
     
