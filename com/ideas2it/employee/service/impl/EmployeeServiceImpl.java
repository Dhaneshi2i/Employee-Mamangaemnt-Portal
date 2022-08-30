/*
 * <p>
 *   Copyright (c) All rights reserved
 * </p>
 */

package com.ideas2it.employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.employee.dao.IEmployeeDao;
import com.ideas2it.employee.dao.impl.EmployeeDaoImpl;
import com.ideas2it.employee.dto.EmployeeDto;
import com.ideas2it.employee.dto.TraineeDto;
import com.ideas2it.employee.dto.TrainerDto;
import com.ideas2it.employee.entity.Employee;
import com.ideas2it.employee.entity.Trainee;
import com.ideas2it.employee.entity.Trainer;
import com.ideas2it.employee.service.IEmployeeService;
import com.ideas2it.employee.util.EmployeeConverter;

public class EmployeeServiceImpl<T extends EmployeeDto> implements IEmployeeService<T> {
    
    private IEmployeeDao<Trainee> traineeEmployeeDao = new EmployeeDaoImpl(new Trainee());
    private IEmployeeDao<Trainer> trainerEmployeeDao = new EmployeeDaoImpl(new Trainer());

    private T value;

    public EmployeeServiceImpl(T value) {
	this.value = value;
    }

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
    @Override
    public void createEmployee(T employee) {
	if (employee instanceof TraineeDto) {
            Trainee trainee = EmployeeConverter.convertTraineeDtoToTrainee((TraineeDto)employee);
	    traineeEmployeeDao.insertEmployee(trainee);
	} else {
            Trainer trainer = EmployeeConverter.convertTrainerDtoToTrainer((TrainerDto)employee);
	    trainerEmployeeDao.insertEmployee(trainer);
 	}
    }

    /**
     * <p>
     *   Returns list of all employees
     * </p>
     * 
     * @return {@link List} of {@link T}
     * 
     */
    @Override
    public List<T> getAllEmployees() {
	if (value instanceof TraineeDto) {
	    return (List<T>)EmployeeConverter.convertTraineeListToTraineeDtoList(traineeEmployeeDao.retriveAllEmployees());
	} else {
	    return (List<T>)EmployeeConverter.convertTrainerListToTrainerDtoList(trainerEmployeeDao.retriveAllEmployees());
	}
    }

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
    @Override
    public T getEmployeeById(String id) {
	if (value instanceof TraineeDto) {
	    return (T)EmployeeConverter.convertTraineeToTraineeDto(traineeEmployeeDao.retriveEmployeeById(id));
	} else {
	    return (T)EmployeeConverter.convertTrainerToTrainerDto(trainerEmployeeDao.retriveEmployeeById(id));
	}
    }

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
    @Override
    public String deleteEmployeeById(String id) {
        Employee employee = new Employee();
	if (value instanceof TraineeDto) {
            for (Trainee trainee : traineeEmployeeDao.retriveAllEmployees()) {
                if (trainee.getId().equals(id)) {
                    trainee.setActiveEmployee(true);
                    employee = trainee;
                }
            }
	    return traineeEmployeeDao.removeEmployeeById(employee);
	} else {
            for (Trainer trainer : trainerEmployeeDao.retriveAllEmployees()) {
                if (trainer.getId().equals(id)) {
                    trainer.setActiveEmployee(true);
                    employee = trainer;
                }
            }
	    return trainerEmployeeDao.removeEmployeeById(employee);
	}
    }

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
    @Override
    public String updateEmployeeById(String id, Long contactNumber) {
        Employee employee = new Employee();
	if (value instanceof TraineeDto) {
            for (Trainee trainee : traineeEmployeeDao.retriveAllEmployees()) {
                if (trainee.getId().equals(id)) {
                    trainee.setContactNumber(contactNumber);
                    employee = trainee;
                }
            }
            return traineeEmployeeDao.updateEmployee(employee);
	} else {
            for (Trainer trainer : trainerEmployeeDao.retriveAllEmployees()) {
                if (trainer.getId().equals(id)) {
                    trainer.setContactNumber(contactNumber);
                    employee = trainer;
                }
            }
            return traineeEmployeeDao.updateEmployee(employee);
	}
    }

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
    @Override
    public void association(String employeeId, List<T> employeesDto) {
        if (value instanceof TraineeDto) {
            //Trainer trainers = new Trainer();
            System.out.println("service 1.1");
            for (Trainer trainer : trainerEmployeeDao.retriveAllEmployees()) {  
                System.out.println("service 1.2");
                if (trainer.getId().equals(employeeId)) {
                    System.out.println("service 1.3");
                    trainer.setTrainee(EmployeeConverter.convertTraineeDtoListToTraineeList((List<TraineeDto>) employeesDto));
                    trainerEmployeeDao.updateEmployeeAssociation(trainer);   
                    break;                 
                }                
            }
        } else { 
            //Trainee trainees = new Trainee();
            System.out.println("service 2.1");
            for (Trainee trainee : traineeEmployeeDao.retriveAllEmployees()) {
                System.out.println("service 2.2");
                if (trainee.getId().equals(employeeId)) {
                    System.out.println("service 2.3");
                    trainee.setTrainer(EmployeeConverter.convertTrainerDtoListToTrainerList((List<TrainerDto>) employeesDto));
                    traineeEmployeeDao.updateEmployeeAssociation(trainee);
                    break;
                }               
            }
        }
    }

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
    @Override
    public List<EmployeeDto> getAssociatedEmployeeDetails(String id) {
	if (value instanceof TraineeDto) {
	    return EmployeeConverter.convertEmployeeListToEmployeeDtoList(traineeEmployeeDao.retrieveAndDisplayAssociatedEmployee(id));
	} else {
	    return EmployeeConverter.convertEmployeeListToEmployeeDtoList(trainerEmployeeDao.retrieveAndDisplayAssociatedEmployee(id));
	}
    }
}

    










