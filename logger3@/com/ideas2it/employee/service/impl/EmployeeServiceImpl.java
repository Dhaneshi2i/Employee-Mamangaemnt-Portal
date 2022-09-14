/*
 * <p>
 *   Copyright (c) All rights reserved
 * </p>
 */

package com.ideas2it.employee.service.impl;

import java.util.List;
import java.util.Set;

import com.ideas2it.employee.dao.IEmployeeDao;
import com.ideas2it.employee.dao.impl.EmployeeDaoImpl;
import com.ideas2it.employee.dto.EmployeeDto;
import com.ideas2it.employee.dto.TraineeDto;
import com.ideas2it.employee.dto.TrainerDto;
import com.ideas2it.employee.entity.Employee;
import com.ideas2it.employee.entity.Trainee;
import com.ideas2it.employee.entity.Trainer;
import com.ideas2it.employee.service.IEmployeeService;
import com.ideas2it.employee.convertor.EmployeeConverter;

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
public class EmployeeServiceImpl<T extends EmployeeDto> implements IEmployeeService<T> {
    
    private IEmployeeDao<Trainee> traineeEmployeeDao = new EmployeeDaoImpl<>(new Trainee());
    private IEmployeeDao<Trainer> trainerEmployeeDao = new EmployeeDaoImpl<>(new Trainer());

    private T employee;

    public EmployeeServiceImpl(T employee) {
	this.employee = employee;
    }

    /**
     * <p>
     *   used to add Employee into List
     * </p>
     * 
     * @param employee {@link T} the employee object
     * 
     * @return {@link void}
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
	if (employee instanceof TraineeDto) {
	    return (List<T>)EmployeeConverter.convertTraineeListToTraineeDtoList(traineeEmployeeDao.retrieveAllEmployees());
	} else {
	    return (List<T>)EmployeeConverter.convertTrainerListToTrainerDtoList(trainerEmployeeDao.retrieveAllEmployees());
	}
    }

    /**
     * <p>
     *   used to get employee by his id
     * </p>
     * 
     * @param id {@link String} id of employee
     * 
     * @return {@link T} the employee object
     * 
     */
    @Override
    public T getEmployeeById(String id) {
	if (employee instanceof TraineeDto) {
            TraineeDto traineeDto = null;
            if (traineeEmployeeDao.retrieveEmployeeById(id) != null) {
                Trainee trainee = traineeEmployeeDao.retrieveEmployeeById(id);
                traineeDto = EmployeeConverter.convertTraineeToTraineeDto(trainee);
                traineeDto.setTrainer(EmployeeConverter.convertTrainerListToTrainerDtoList(trainee.getTrainer()));
	        return (T)traineeDto;
            } else {
                return (T)traineeDto;
            }
	} else {
	    TrainerDto trainerDto = null;
            if (trainerEmployeeDao.retrieveEmployeeById(id) != null) {
                Trainer trainer = trainerEmployeeDao.retrieveEmployeeById(id);
                trainerDto = EmployeeConverter.convertTrainerToTrainerDto(trainer);
                trainerDto.setTrainee(EmployeeConverter.convertTraineeListToTraineeDtoList(trainer.getTrainee()));
	        return (T)trainerDto;
            } else {
                return (T)trainerDto;
            }
	}
    }

    /**
     * <p>
     *   used to remove the Employee by his id
     * </p>
     * 
     * @param id {@link String} id of employee
     * 
     * @return {@link String} deletion message
     * 
     */
    @Override
    public String deleteEmployeeById(String id) {
	if (employee instanceof TraineeDto) {
            Trainee trainee = traineeEmployeeDao.retrieveEmployeeById(id);
            trainee.setActiveEmployee(true);
            trainee.getTrainer().removeAll(trainee.getTrainer());
	    return traineeEmployeeDao.updateEmployee(trainee);
	} else {
            Trainer trainer = trainerEmployeeDao.retrieveEmployeeById(id);
            trainer.setActiveEmployee(true);
            trainer.getTrainee().removeAll(trainer.getTrainee());
	    return trainerEmployeeDao.updateEmployee(trainer);
	}
    }

    /**
     * <p>
     *   used to update the Employee by his id
     * </p>
     * 
     * @param id {@link String} id of employee 
     *
     * @param contactNumber{@link long} mobile number of employee
     * 
     * @return {@link String} the update message
     * 
     */
    @Override
    public String updateEmployeeById(String id, Long contactNumber) {
	if (employee instanceof TraineeDto) {
            Trainee trainee = traineeEmployeeDao.retrieveEmployeeById(id);
            trainee.setContactNumber(contactNumber);
            return traineeEmployeeDao.updateEmployee(trainee);
	} else {
            Trainer trainer = trainerEmployeeDao.retrieveEmployeeById(id);
            trainer.setContactNumber(contactNumber);
            return trainerEmployeeDao.updateEmployee(trainer);
	}
    }

    /**
     * <p>
     *   used to associate the employees by their id
     * </p>
     * 
     * @param employeesDto {@link List} of {@link T} list of employees
     * 
     * @param employeeId {@link String} id of employee
     * 
     * @return {@link String} the update message
     */	
    @Override
    public String association(String employeeId, List<T> employeesDto) {
        if (employee instanceof TraineeDto) {
            Trainer trainer = trainerEmployeeDao.retrieveEmployeeById(employeeId);
            trainer.setTrainee(EmployeeConverter.convertTraineeDtoListToTraineeList((List<TraineeDto>) employeesDto));
            return trainerEmployeeDao.updateEmployee(trainer);

        } else { 
            Trainee trainee = traineeEmployeeDao.retrieveEmployeeById(employeeId);
            trainee.setTrainer(EmployeeConverter.convertTrainerDtoListToTrainerList((List<TrainerDto>) employeesDto));
            return traineeEmployeeDao.updateEmployee(trainee);
        }
    }
}

    