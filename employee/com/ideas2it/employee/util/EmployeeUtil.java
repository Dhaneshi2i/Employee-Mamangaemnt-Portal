package com.ideas2it.employee.util;

import java.time.LocalDate;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmployeeUtil {
    /* This class gets values from the employee controller as user input and return them as required */
    private static int idCounter = 0;
    private static final String PREFIX_FOR_ID = "I";

    /**
     * method is used to generate Id for the Employee
     * @return {@link String} id
     */
    public static String generateId() {
	String id = null;
	LocalDate currentDate = LocalDate.now();
	int year = currentDate.getYear();
	idCounter++;
	id = (PREFIX_FOR_ID + year % 100 + idCounter);
	return id;
    }

    /** It auto creates employee email for every employee using their name and id */
    public static String generateEmailId(String name, String id) {
	StringBuilder employeeMailId = new StringBuilder();
	employeeMailId.append(name.toLowerCase()).append(id.toLowerCase())
		      .append("@ideas2it.com");
	
	return employeeMailId.toString();
    }

    public static boolean isValidFirstName(String firstName) {
        String regex = "[A-Za-z\\s]{3,30}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(firstName);
        return matcher.matches();
    }

    public static boolean isValidLastName(String lastName) {
        String regex = "[A-Za-z\\s]{0,30}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(lastName);
        return matcher.matches();
    }

    public static boolean isValidateContactNumber(String contactNumber) {
        String regex = "^[6-9]\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contactNumber);
        return matcher.matches();
    }
}




	