package com.ideas2it.employee.dto;

import java.time.LocalDate;
import java.time.Period;

public class EmployeeDto {

    private String id;

    private String firstName;

    private String lastName;

    private Long contactNumber;

    private String companyEmailId;

    private LocalDate dateOfBirth;

    private LocalDate dateOfJoining;

    private boolean isActiveEmployee = false;

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setId(String id) {
	this.id = id;
    } 

    public String getId() {
	return id;
    }

    public void setContactNumber(Long contactNumber) {
	this.contactNumber = contactNumber;
    }

    public Long getContactNumber() {
	return contactNumber;
    }

    public void setCompanyEmailId(String companyEmailId) {
        this.companyEmailId = companyEmailId;
    }

    public String getCompanyEmailId(){
        return companyEmailId;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
	return dateOfBirth;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
	this.dateOfJoining = dateOfJoining;
    }

    public LocalDate getDateOfJoining() {
	return dateOfJoining;
    }

    public void setIsActiveEmployee(boolean isActiveEmployee) {

        this.isActiveEmployee = isActiveEmployee;
    }

    public boolean getActiveEmployee() {

        return isActiveEmployee;
    }

    public int getAgeFromDateOfBirth() { 
	LocalDate present = LocalDate.now();          
        return (Period.between(dateOfBirth, present).getYears()); 
    }

    public int getExperienceFromDateOfJoining() {
	LocalDate present = LocalDate.now();
	return (Period.between(dateOfJoining, present).getYears());
    }
   
    public String toString() {
	StringBuilder stringBuilder = new StringBuilder();
	stringBuilder.append("First Name: ").append(this.getFirstName())
                     .append("\nLast Name: ").append(this.getLastName())
                     .append("\nId: ").append(this.getId())
                     .append("\nCompany EmailId: ").append(this.getCompanyEmailId())
                     .append("\nAge: ").append(this.getAgeFromDateOfBirth())
		     .append("\nExperience: ").append(this.getExperienceFromDateOfJoining());
		     
	return stringBuilder.toString();
    }
}