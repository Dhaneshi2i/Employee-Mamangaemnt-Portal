/*
 * <p>
 *   Copyright (c) All rights reserved
 * </p>
 */

package com.ideas2it.employee.util;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.employee.dto.EmployeeDto;
import com.ideas2it.employee.dto.TraineeDto;
import com.ideas2it.employee.dto.TrainerDto;
import com.ideas2it.employee.entity.Employee;
import com.ideas2it.employee.entity.Trainee;
import com.ideas2it.employee.entity.Trainer;

/**
 * <p>
 *   Implemented to convert Dto object to entity object and vice-versa 
 * </p>
 *
 * <p>  
 *   This file is created on 27/07/2022
 *   @author : Dhanesh Kumar
 * </p>
 */
public class EmployeeConverter {

    /**
     * <p>
     *   used to convert Dto class to entity class of trainee
     * <p>
     *
     * @param traineeDto {@link TraineeDto} the traineeDto object
     *
     * @return trainee {@link Trainee} the trainee object
     *
     */  
    public static Trainee convertTraineeDtoToTrainee(TraineeDto traineeDto) {
        Trainee trainee = new Trainee();
        trainee.setFirstName(traineeDto.getFirstName());
        trainee.setLastName(traineeDto.getLastName());
        trainee.setId(traineeDto.getId());
        trainee.setContactNumber(traineeDto.getContactNumber());
        trainee.setCompanyEmailId(traineeDto.getCompanyEmailId());
        trainee.setDateOfBirth(traineeDto.getDateOfBirth());
        trainee.setDateOfJoining(traineeDto.getDateOfJoining());
        trainee.setReportingPersonName(traineeDto.getReportingPersonName());
        return trainee;
    }

    /**
     * <p>
     *   used to convert Dto class to entity class of trainer
     * <p>
     *
     * @param trainerDto {@link TrainerDto} the trainerDto object
     *
     * @return trainer {@link Trainer} the trainer object
     *
     */ 
    public static Trainer convertTrainerDtoToTrainer(TrainerDto trainerDto) {
        Trainer trainer = new Trainer();
        trainer.setFirstName(trainerDto.getFirstName());
        trainer.setLastName(trainerDto.getLastName());
        trainer.setId(trainerDto.getId());
        trainer.setContactNumber(trainerDto.getContactNumber());
        trainer.setCompanyEmailId(trainerDto.getCompanyEmailId());
        trainer.setDateOfBirth(trainerDto.getDateOfBirth());
        trainer.setDateOfJoining(trainerDto.getDateOfJoining());
        trainer.setProjectsWorked(trainerDto.getProjectsWorked());
        return trainer;
    }

    /**
     * <p>
     *   used to convert entity class to Dto class of trainee
     * <p>
     *
     * @param trainee {@link Trainee} the trainee object
     *
     * @return traineeDto {@link TraineeDto} the traineeDto object
     *
     */ 
    public static TraineeDto convertTraineeToTraineeDto(Trainee trainee) {
        TraineeDto traineeDto = new TraineeDto();
        traineeDto.setFirstName(trainee.getFirstName());
        traineeDto.setLastName(trainee.getLastName());
        traineeDto.setId(trainee.getId());
        traineeDto.setContactNumber(trainee.getContactNumber());
        traineeDto.setCompanyEmailId(trainee.getCompanyEmailId());
        traineeDto.setDateOfBirth(trainee.getDateOfBirth());
        traineeDto.setDateOfJoining(trainee.getDateOfJoining());
        traineeDto.setReportingPersonName(trainee.getReportingPersonName());
        return traineeDto;
    }

    /**
     * <p>
     *   used to convert entity class to Dto class of trainer
     * <p>
     *
     * @param trainer {@link Trainer} the trainer object
     *
     * @return trainerDto {@link TrainerDto} the trainerDto object
     *
     */
    public static TrainerDto convertTrainerToTrainerDto(Trainer trainer) {
        TrainerDto trainerDto = new TrainerDto();
        trainerDto.setFirstName(trainer.getFirstName());
        trainerDto.setLastName(trainerDto.getLastName());
        trainerDto.setId(trainer.getId());
        trainerDto.setContactNumber(trainer.getContactNumber());
        trainerDto.setCompanyEmailId(trainer.getCompanyEmailId());
        trainerDto.setDateOfBirth(trainer.getDateOfBirth());
        trainerDto.setDateOfJoining(trainer.getDateOfJoining());
        trainerDto.setProjectsWorked(trainer.getProjectsWorked());
        return trainerDto; 
    }

    /**
     * <p>
     *   used to convert entity list to Dto list of trainee
     * <p>
     *
     * @param  traineesDto {@link List} of {@link TraineeDto} the traineeDto object
     *
     * @return trainees {@link List} of {@link Trainee} the trainee object
     *
     */ 
    public static List<Trainee> convertTraineeDtoListToTraineeList(List<TraineeDto> traineesDto) {
        List<Trainee> trainees = new ArrayList<>();
        Trainee trainee = null;
        for (TraineeDto traineeDto : traineesDto) {
            trainee = convertTraineeDtoToTrainee(traineeDto);
            trainees.add(trainee);
        }
        return trainees;
    }
 
    /**
     * <p>
     *   used to convert entity list to Dto list of trainer
     * <p>
     *
     * @param  trainersDto {@link List} of {@link TrainerDto} the trainerDto object
     *
     * @return trainers {@link List} of {@link Trainer} the trainer object
     *
     */  
    public static List<Trainer> convertTrainerDtoListToTrainerList(List<TrainerDto> trainersDto) {
        List<Trainer> trainers = new ArrayList<>();
        Trainer trainer = null;
        for (TrainerDto trainerDto : trainersDto) {
            trainer = convertTrainerDtoToTrainer(trainerDto);
            trainers.add(trainer);
        }
        return trainers;
    }

    /**
     * <p>
     *   used to convert entity list to Dto list of trainee
     * <p>
     *
     * @param  trainees {@link List} of {@link Trainee} the trainee object
     *
     * @return traineesDto {@link List} of {@link TraineeDto} the traineeDto object
     *
     */
    public static List<TraineeDto> convertTraineeListToTraineeDtoList(List<Trainee> trainees) {
        List<TraineeDto> traineesDto = new ArrayList<>(); 
        TraineeDto traineeDto = null;
        for (Trainee trainee : trainees) {
            traineeDto = convertTraineeToTraineeDto(trainee);
            traineesDto.add(traineeDto);
        }
        return traineesDto;
    }

    /**
     * <p>
     *   used to convert entity list to Dto list of trainer
     * <p>
     *
     * @param  trainers {@link List} of {@link Trainer} the trainer object
     *
     * @return trainersDto {@link List} of {@link TrainerDto} the trainerDto object
     *
     */
    public static List<TrainerDto> convertTrainerListToTrainerDtoList(List<Trainer> trainers) {
        List<TrainerDto> trainersDto = new ArrayList<>(); 
        TrainerDto trainerDto = null;
        for (Trainer trainer : trainers) {
            trainerDto = convertTrainerToTrainerDto(trainer);
            trainersDto.add(trainerDto);
        }
        return trainersDto;
    } 

    /**
     * <p>
     *   used to convert entity list to Dto list of employee
     * <p>
     *
     * @param  employees {@link List} of {@link Employee} the employee object
     *
     * @return employeesDto {@link List} of {@link EmployeeDto} the employeeDto object
     *
     */   
    public static List<EmployeeDto> convertEmployeeListToEmployeeDtoList (List<Employee> employees) {
        List<EmployeeDto> employeesDto = new ArrayList<>(); 
        TrainerDto trainerDto = null;
        TraineeDto traineeDto = null;
       
        for(Employee employee : employees) {
            if (employee  instanceof Trainee) {  
                traineeDto  = convertTraineeToTraineeDto((Trainee)employee);
                employeesDto.add(traineeDto);          
             } else  {
                trainerDto  = convertTrainerToTrainerDto((Trainer)employee);
                employeesDto.add(trainerDto);  
             }
         }
         return employeesDto;
     }
}

    
        