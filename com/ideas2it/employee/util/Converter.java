package com.ideas2it.employee.util;

import java.util.LinkedList;
import java.util.List;

import com.ideas2it.employee.dto.EmployeeDto;
import com.ideas2it.employee.dto.TraineeDto;
import com.ideas2it.employee.dto.TrainerDto;
import com.ideas2it.employee.entity.Employee;
import com.ideas2it.employee.entity.Trainee;
import com.ideas2it.employee.entity.Trainer;

public class Converter {

    public static Trainee convertTraineeDtoToTrainee(TraineeDto traineeDto) {
        Trainee trainee = new Trainee();
        trainee.setName(traineeDto.getName());
        trainee.setId(traineeDto.getId());
        trainee.setContactNumber(traineeDto.getContactNumber());
        trainee.setDateOfBirth(traineeDto.getDateOfBirth());
        trainee.setDateOfJoining(traineeDto.getDateOfJoining());
        trainee.setReportingPersonName(traineeDto.getReportingPersonName());
        return trainee;
    }

    public static Trainer convertTrainerDtoToTrainer(TrainerDto trainerDto) {
        Trainer trainer = new Trainer();
        trainer.setName(trainerDto.getName());
        trainer.setId(trainerDto.getId());
        trainer.setContactNumber(trainerDto.getContactNumber());
        trainer.setDateOfBirth(trainerDto.getDateOfBirth());
        trainer.setDateOfJoining(trainerDto.getDateOfJoining());
        trainer.setProjectsWorked(trainerDto.getProjectsWorked());
        return trainer;
    }

    public static TraineeDto convertTraineeToTraineeDto(Trainee trainee) {
        TraineeDto traineeDto = new TraineeDto();
        traineeDto.setName(trainee.getName());
        traineeDto.setId(trainee.getId());
        traineeDto.setContactNumber(trainee.getContactNumber());
        traineeDto.setDateOfBirth(trainee.getDateOfBirth());
        traineeDto.setDateOfJoining(trainee.getDateOfJoining());
        traineeDto.setReportingPersonName(trainee.getReportingPersonName());
        return traineeDto;
    }

    public static TrainerDto convertTrainerToTrainerDto(Trainer trainer) {
        TrainerDto trainerDto = new TrainerDto();
        trainerDto.setName(trainer.getName());
        trainerDto.setId(trainer.getId());
        trainerDto.setContactNumber(trainer.getContactNumber());
        trainerDto.setDateOfBirth(trainer.getDateOfBirth());
        trainerDto.setDateOfJoining(trainer.getDateOfJoining());
        trainerDto.setProjectsWorked(trainer.getProjectsWorked());
        return trainerDto; 
    }

    public static List<TraineeDto> convertTraineeListToTraineeDtoList(List<Trainee> trainees) {
        List<TraineeDto> traineesDto = new LinkedList(); 
        TraineeDto traineeDto = null;
        for (Trainee trainee : trainees) {
            traineeDto = convertTraineeToTraineeDto(trainee);
            traineesDto.add(traineeDto);
        }
        return traineesDto;
    }

    public static List<TrainerDto> convertTrainerListToTrainerDtoList(List<Trainer> trainers) {
        List<TrainerDto> trainersDto = new LinkedList(); 
        TrainerDto trainerDto = null;
        for (Trainer trainer : trainers) {
            trainerDto = convertTrainerToTrainerDto(trainer);
            trainersDto.add(trainerDto);
        }
        return trainersDto;
    }

    public static List<EmployeeDto> convertEmployeeListToEmployeeDtoList(List<Employee> employees) {
        List<EmployeeDto> employeeDtoList = new LinkedList<>();

        TraineeDto traineeDto = null;
        TrainerDto trainerDto = null;

        for (Employee employee : employees) {
            if (employee instanceof Trainee) {
                traineeDto = convertTraineeToTraineeDto((Trainee)employee);
                employeeDtoList.add(traineeDto);
            } else {
                trainerDto = convertTrainerToTrainerDto((Trainer)employee);
                employeeDtoList.add(trainerDto);
            }
        }
        return employeeDtoList;
    }
  
    public static List<Trainee> convertTraineeDtoListToTraineeList(List<TraineeDto> traineesDto) {
        Trainee trainee = new Trainee();
        List<Trainee> trainees = new LinkedList<>();
        for (TraineeDto traineeDto : traineesDto) {
            trainee = convertTraineeDtoToTrainee(traineeDto);
            trainees.add(trainee);
        }
        return trainees;
    }

    public static List<Trainer> convertTrainerDtoListToTrainerList(List<TrainerDto> trainersDto) {
        Trainer trainer = new Trainer();
        List<Trainer> trainers = new LinkedList<>();
        for (TrainerDto trainerDto : trainersDto) {
            trainer = convertTrainerDtoToTrainer(trainerDto);
            trainers.add(trainer);
        }
        return trainers;
    }
    
}

    
        