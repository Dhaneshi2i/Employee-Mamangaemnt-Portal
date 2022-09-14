package com.ideas2it.employee.util;

import java.time.LocalDate;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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
public class EmployeeUtil {
    /* This class gets values from the employee controller as user input and return them as required */
    private static int idCounter = 0;
    private static final String PREFIX_FOR_ID = "I";

    /**
     * <p>
     *   used to generate id for the employee
     * </p>
     *
     * @return {@link String} id
     *
     */
    public static String generateId() {
	String id = null;
	LocalDate currentDate = LocalDate.now();
	int year = currentDate.getYear();
	idCounter++;
	id = (PREFIX_FOR_ID + year % 100 + idCounter);
	return id;
    }

    /**
     * <p>
     *   used to generate mailId for the employee
     * </p>
     *
     * @param firstName {@link String} first name of the employee
     *
     * @param id {@link String} id of the employee
     * 
     * @return {@link String} EmailId
     *
     */
    public static String generateEmailId(String firstName, String id) {
	StringBuilder employeeEmailId = new StringBuilder();
	employeeEmailId.append(firstName.toLowerCase()).append(id.toLowerCase())
		      .append("@ideas2it.com");
	
	return employeeEmailId.toString();
    }

    /**
     * <p>
     *   used to validate employees first name
     * </p>
     * 
     * @param firstName {@link String} first name of the employee 
     * 
     * @return {@link Boolean} whether first name is valid or not
     * 
     */
    public static boolean isValidFirstName(String firstName) {
        String regex = "[A-Za-z\\s]{2,30}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(firstName);
        return matcher.matches();
    }

    /**
     * <p>
     *   used to validate employees last name
     * </p>
     * 
     * @param lastName {@link String} last name of the employee 
     * 
     * @return {@link Boolean} whether last name is valid or not
     * 
     */
    public static boolean isValidLastName(String lastName) {
        String regex = "[A-Za-z\\s]{0,30}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(lastName);
        return matcher.matches();
    }

    /**
     * <p>
     *   used to validate employees contact number
     * </p>
     * 
     * @param contactNumber {@link Long} contact number of the employee 
     * 
     * @return {@link Boolean} whether contact number is valid or not
     * 
     */
    public static boolean isValidateContactNumber(Long contactNumber) {
        String phoneNumber = String.valueOf(contactNumber);
        String regex = "^[6-9]\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}



	