package com.ideas2it.employee.dto;

import java.time.LocalDate;
import java.time.Period;

public class EmployeeDto {

    private String id;

    private String firstName;

    private String lastName;

    private Long contactNumber;

    private LocalDate dateOfBirth;

    private LocalDate dateOfJoining;

    private boolean deleted = false;

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

    public void setDeleted(boolean deleted) {

        this.deleted = deleted;
    }

    public boolean getDeleted() {

        return deleted;
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
	stringBuilder.append("First_Name: ").append(this.getFirstName()).append("\nId: ")
                     .append(this.getId()).append("\nAge: ")
		     .append(this.getAgeFromDateOfBirth())
		     .append("\nExperience: ").append(this.getExperienceFromDateOfJoining());
		     
	return stringBuilder.toString();
    }
}