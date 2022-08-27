package com.ideas2it.employee.util;

import java.time.LocalDate;

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
}



	