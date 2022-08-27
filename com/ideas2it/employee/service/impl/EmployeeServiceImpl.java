package com.ideas2it.employee.service.impl;

import java.util.List;

import com.ideas2it.employee.dao.IEmployeeDao;
import com.ideas2it.employee.dao.impl.EmployeeDaoImpl;
import com.ideas2it.employee.dto.EmployeeDto;
import com.ideas2it.employee.dto.TraineeDto;
import com.ideas2it.employee.dto.TrainerDto;
import com.ideas2it.employee.entity.Trainee;
import com.ideas2it.employee.entity.Trainer;
import com.ideas2it.employee.util.Converter;
import com.ideas2it.employee.service.IEmployeeService;

public class EmployeeServiceImpl<T extends EmployeeDto> implements IEmployeeService<T> {
    
    private IEmployeeDao<Trainee> traineeEmployeeDao = new EmployeeDaoImpl(new Trainee());
    private IEmployeeDao<Trainer> trainerEmployeeDao = new EmployeeDaoImpl(new Trainer());

    private T value;

    public EmployeeServiceImpl(T value) {
	this.value = value;
    }

    @Override
    public void createEmployee(T employee) {
	if (employee instanceof TraineeDto) {
            Trainee trainee = Converter.convertTraineeDtoToTrainee((TraineeDto)employee);
	    traineeEmployeeDao.insertEmployee((Trainee)trainee);
	} else {
            Trainer trainer = Converter.convertTrainerDtoToTrainer((TrainerDto)employee);
	    trainerEmployeeDao.insertEmployee((Trainer)trainer);
 	}
    }

    @Override
    public List<T> getAllEmployees() {
	if (value instanceof TraineeDto) {
	    return (List<T>)Converter.convertTraineeListToTraineeDtoList(traineeEmployeeDao.retriveAllEmployees());
	} else {
	    return (List<T>)Converter.convertTrainerListToTrainerDtoList(trainerEmployeeDao.retriveAllEmployees());
	}
    }

    @Override
    public T getEmployeeById(String id) {
	if (value instanceof TraineeDto) {
	    return (T)Converter.convertTraineeToTraineeDto(traineeEmployeeDao.retriveEmployeeById(id));
	} else {
	    return (T)Converter.convertTrainerToTrainerDto(trainerEmployeeDao.retriveEmployeeById(id));
	}
    }

    @Override
    public String deleteEmployeeById(String id) {
	if (value instanceof TraineeDto) {
	    return traineeEmployeeDao.removeEmployeeById(id);
	} else {
	    return trainerEmployeeDao.removeEmployeeById(id);
	}
    }

    @Override
    public String updateEmployeeById(String id, Long contactNumber) {
	if (value instanceof TraineeDto) {
	    return traineeEmployeeDao.updateEmployeeById(id, contactNumber);
	} else {
	    return trainerEmployeeDao.updateEmployeeById(id, contactNumber);
	}
    }
	
    @Override
    public String association(String employeeId, List<T> employeesId) {
	if (value instanceof TraineeDto) {
	    return traineeEmployeeDao.employeeAssociation(employeeId, (convertTrainerDtoListToTrainerList((List<TrainerDto>)employeesId);
	} else { 
	    return trainerEmployeeDao.employeeAssociation(employeeId, (convertTraineeDtoListToTraineeList((List<TraineeDto>)employeesId);
	}
    }

    @Override
    public List<EmployeeDto> getAssociatedEmployeeDetails(String id) {
	if (value instanceof TraineeDto) {
	    return Converter.convertEmployeeListToEmployeeDtoList(traineeEmployeeDao.retrieveAndDisplayAssociatedEmployee(id));
	} else {
	    return Converter.convertEmployeeListToEmployeeDtoList(trainerEmployeeDao.retrieveAndDisplayAssociatedEmployee(id));
	}
    }
}
    
































