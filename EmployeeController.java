/*
 * <p>
 *   Copyright (c) All rights reserved
 * </p>
 */

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ideas2it.employee.exception.EmployeeRunTimeException;
import com.ideas2it.employee.dto.EmployeeDto;
import com.ideas2it.employee.dto.TraineeDto;
import com.ideas2it.employee.dto.TrainerDto;
import com.ideas2it.employee.service.IEmployeeService;
import com.ideas2it.employee.service.impl.EmployeeServiceImpl;
import com.ideas2it.employee.util.EmployeeUtil;                         

/**
 * <p>
 *   Implemented to create a new employee or search, update, and delete
 *   existing employee 
 * </p>
 *
 * <p>  
 *   This file is created on 27/07/2022
 *   @author : Dhanesh Kumar
 * </p>
 */

public class EmployeeController {

    private Scanner scanner = new Scanner(System.in); 
    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private static IEmployeeService<TraineeDto> traineeDtoService = new EmployeeServiceImpl(new TraineeDto());
    private static IEmployeeService<TrainerDto> trainerDtoService = new EmployeeServiceImpl(new TrainerDto()); 
    
    public static void main(String[] args) {
        EmployeeController controller = new EmployeeController();
	logger.info("\nWelome to ideas2IT Employee Management Portal !!!");
	controller.init();
    }
	
    /**
     * <p>
     *   Shows the list of options for employee manipulation
     * </p>
     */
    public void init() {

	String validate;
	do {
	    logger.info("********************************************************* " + "\n");
	    logger.info("Enter 1 to Add Employee ");
	    logger.info("Enter 2 to Get employee details ");
	    logger.info("Enter 3 to Get specific employee details ");
	    logger.info("Enter 4 to update employee details ");
	    logger.info("Enter 5 to delete a employee ");
	    logger.info("Enter 6 to add associates ");
	    int userChoice = scanner.nextInt();
	    switch (userChoice) {
	    case 1: 
  	        logger.info("Enter 1 to add a trainee or 2 to add a trainer: " + "\n");
		int userInput = scanner.nextInt();
		switch (userInput) {			  
		case 1:
		    logger.info("Enter the number of trainees to be created: ");
		    int NoOfTrainees = scanner.nextInt();
	            for (int i = 0;i < NoOfTrainees;i++) {
		        logger.info("Enter the trainee "+(i+1)+" details: " + "\n");
			createEmployee(1);
		    }
		    break;

                case 2: 
	            logger.info("Enter the number of trainers to be created: ");
		    int NoOfTrainers = scanner.nextInt();
	            for (int i = 0;i < NoOfTrainers;i++) {
                        logger.info("Enter the trainer "+(i+1)+" details: " + "\n");
		        createEmployee(2); 
		    }
		    break;
                }
		break;

	    case 2: 
	        logger.info("Enter 1 to display trainee details or 2 for trainer details or 3 for Trainee Association details or 4 for Trainer Association details: " + "\n");
		int userCall = scanner.nextInt();
		switch (userCall) {
		case 1:	
		    logger.info("Display Trainee Details" + "\n");
		    displayAllTrainee();
		    break;
		    
	        case 2:		
	            logger.info("Display Trainer Details" + "\n");
		    displayAllTrainer();
		    break;
		    
		case 3:
                    logger.info("Display Trainee Association details" + "\n");
		    //displayAssociatedEmployeeDetails(1);   
		    break;

		case 4:
                    logger.info("Display Trainer Association details" + "\n");
		    //displayAssociatedEmployeeDetails(2);   
		    break;
		}
		break;
		    	
            case 3:
	        logger.info("Enter 1 for trainee or 2 for trainer: " + "\n");
                int userChoiceForDisplay = scanner.nextInt();
		switch (userChoiceForDisplay) {
		case 1:
                    logger.info("Enter Trainee Id: ");
		    String traineeId = scanner.next();
		    displayTraineeById(traineeId);
		    break;

                case 2:
                    logger.info("Enter Trainer Id: " + "\n");
		    String trainerId = scanner.next();
		    displayTrainerById(trainerId);
		    break;	
		}
		break;		    

	    case 4: 
	        logger.info("Enter 1 to update trainee or 2 for trainer " + "\n");
		int userChoiceForUpdate = scanner.nextInt();
		switch (userChoiceForUpdate) {
                case 1:
		    try {
		        updateEmployeeById(1);	
		    } catch (EmployeeRunTimeException e) {
			logger.error(e.toString());
		    }
		    break;

	        case 2: 
		    try {		   
		        updateEmployeeById(2);
		    } catch (EmployeeRunTimeException e) {
			logger.error(e.toString());
		    }
		    break;
		}
		break;

	    case 5: 
		logger.info("Enter 1 for trainee or 2 for trainer: " + "\n");
		int userChoiceForRemove = scanner.nextInt();
		switch (userChoiceForRemove) {
		case 1:
		    logger.info("Enter trainee id: ");
		    String traineeId = scanner.next();
		    logger.info(traineeDtoService.deleteEmployeeById(traineeId));
		    break; 
		    
		case 2: 
                    logger.info("Enter trainer id: ");
		    String trainerId = scanner.next();
		    logger.info(trainerDtoService.deleteEmployeeById(trainerId));
		    break;
		}
		break;		    	

	    case 6:
		logger.info("Enter 1 to add trainee associates or 2 for trainer associates" + "\n");
		int userChoiceForAssociate = scanner.nextInt();
		switch (userChoiceForAssociate) {
		case 1:
                    addAssociates(1);
		    break;

		case 2:
		    addAssociates(2);
		    break;
		}
		break;
 
	    default: logger.info("Invalid Input");
	    }
	    logger.info("Do you want to continue. Type 'yes' or 'no': ");
	    validate = scanner.next();
	} while (validate.equalsIgnoreCase("yes"));

    }   

    /**
     * <p>
     *   Get the required employee details to create an employee
     * </p>
     *
     */
    public void createEmployee(int userInput) { 
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	logger.info("Enter your Name: ");
	String name = scanner.next();

	String id = EmployeeUtil.generateId();	
	logger.info("ID: " + id);
	
	logger.info("Enter your Contact Number: ");
	Long contactNumber = scanner.nextLong();
	
	scanner.nextLine();
	logger.info("Enter your date of birth in ('dd-MM-yyyy') format: ");
	String employeeDateOfBirth = scanner.next();
	LocalDate dateOfBirth = LocalDate.parse(employeeDateOfBirth, format);
	
	logger.info("Enter your Date of Joining in ('dd-MM-yyyy') format: ");	
        String employeeDateOfJoining = scanner.next();
	LocalDate dateOfJoining = LocalDate.parse(employeeDateOfJoining, format);

	String emailId = EmployeeUtil.generateEmailId(name, id);       

	if (userInput == 1) {
	    
 	    scanner.nextLine();
	    TraineeDto traineeDto = new TraineeDto();
            logger.info("Enter your reporting person name: ");
            String reportingPersonName = scanner.nextLine();
	   	
	    traineeDto.setName(name);
	    traineeDto.setId(id);
 	    traineeDto.setContactNumber(contactNumber);
	    traineeDto.setDateOfBirth(dateOfBirth);
	    traineeDto.setDateOfJoining(dateOfJoining);
	    traineeDto.setReportingPersonName(reportingPersonName);
	    traineeDtoService.createEmployee(traineeDto);

	} else if (userInput == 2) {

	    TrainerDto trainerDto = new TrainerDto();
	    logger.info("Enter your Projects Worked: ");
            byte projectsWorked = scanner.nextByte();
                
	    trainerDto.setName(name);	
	    trainerDto.setId(id);
	    trainerDto.setContactNumber(contactNumber);
	    trainerDto.setDateOfBirth(dateOfBirth);
	    trainerDto.setDateOfJoining(dateOfJoining);
	    trainerDto.setProjectsWorked(projectsWorked);
	    trainerDtoService.createEmployee(trainerDto);
	}
    }

    public void displayAllTrainee() {
	for (TraineeDto traineeDto : traineeDtoService.getAllEmployees()) {	    
	    logger.info(traineeDto.toString());
        }
    }

    public void displayAllTrainer() {
	for (TrainerDto trainerDto : trainerDtoService.getAllEmployees()) {
	    logger.info(trainerDto.toString());
	}
    }

    public void displayTraineeById(String id) { 
	TraineeDto traineeDto = traineeDtoService.getEmployeeById(id);
        logger.info(traineeDto.toString());	
    }

    public void displayTrainerById(String id) {
	TrainerDto trainerDto = trainerDtoService.getEmployeeById(id);
	logger.info(trainerDto.toString());	
    }

    public void addAssociates(int userInput) {
	if (userInput == 1) {
            scanner.nextLine();
            displayAllTrainee();
	    logger.info("Enter the trainee id: ");
	    String traineeId = scanner.nextLine();
            
            displayAllTrainer();
            logger.info("Enter the trainer's id's you want to add: ");
	    String[] trainersIds = scanner.next().split(",");
            System.out.println("length : "+ trainersIds.length);
            List<TrainerDto> trainersDto = new ArrayList<>();
            for (int i = 0; i<trainersIds.length;i++) {
                TrainerDto trainerDto = trainerDtoService.getEmployeeById(trainersIds[i]);
                trainersDto.add(trainerDto);
            } 
            trainerDtoService.association(traineeId, trainersDto);
     
	} else if (userInput == 2) {   
            scanner.nextLine();
            displayAllTrainer();
	    logger.info("Enter the trainer id: ");
	    String trainerId = scanner.next();
            
            displayAllTrainee();
	    logger.info("Enter the trainee's id's you want to add: ");
	    String[] traineesIds = scanner.next().split(",");

            List<TraineeDto> traineesDto = new ArrayList<>();
            for (int i = 0;i < traineesIds.length;i++) { 
                TraineeDto traineeDto = traineeDtoService.getEmployeeById(traineesIds[i]);
                traineesDto.add(traineeDto);
            }
            traineeDtoService.association(trainerId, traineesDto);
	}	    
    }

    public void displayAssociatedEmployeeDetails(int userInput) {
	if (userInput == 1) {
	    logger.info("Enter the trainee id: ");
	    String traineeId = scanner.next();
	    boolean flag = true;
	    for ( EmployeeDto employeeDto : traineeDtoService.getAssociatedEmployeeDetails(traineeId)) {
		if (employeeDto instanceof TraineeDto && flag == true) {
		    logger.info(employeeDto.toString());
		    logger.info("Trainer's List");
		    flag = false;
		} else {
		    logger.info(employeeDto.toString());
		}
	    }
	} else if (userInput == 2) {
	    logger.info("Enter the trainer id: ");
	    String trainerId = scanner.next();
	    boolean flag = true;
	    for ( EmployeeDto employeeDto : trainerDtoService.getAssociatedEmployeeDetails(trainerId)) {
		if (employeeDto instanceof TrainerDto && flag == true) {
		    logger.info(employeeDto.toString());
		    logger.info("Trainee's List");
		    flag = false;
		} else {
		    logger.info(employeeDto.toString());
		}
	    }
	}
    }
	 
    public void updateEmployeeById(int userInput) throws EmployeeRunTimeException {
	logger.info("Enter Employee id: ");
        String id = scanner.next();	
	if (userInput == 1) {
	    if (traineeDtoService.getEmployeeById(id) == null) {
		throw new EmployeeRunTimeException("Id does not exist");
	    } else {	
        	logger.info("Enter your contact number: ");
	        Long contactNumber = scanner.nextLong();
	        logger.info(traineeDtoService.updateEmployeeById(id, contactNumber));
	    }
	} else {
	    if (trainerDtoService.getEmployeeById(id) == null) {
		throw new EmployeeRunTimeException("Id does not exist");
	    } else {
 		logger.info("Enter your contact number: ");
	        Long contactNumber = scanner.nextLong();
	        logger.info(trainerDtoService.updateEmployeeById(id, contactNumber));
	    }
	}
    }	    
}

	    
	