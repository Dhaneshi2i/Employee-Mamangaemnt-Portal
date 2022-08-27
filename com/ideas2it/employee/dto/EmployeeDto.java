package com.ideas2it.employee.dto;

import java.time.LocalDate;
import java.time.Period;

public class EmployeeDto {

    private String id;

    private String name;

    private Long contactNumber;

    private LocalDate dateOfBirth;

    private LocalDate dateOfJoining;

    private boolean deleted = false;

    public void setName(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
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
	stringBuilder.append("Name: ").append(this.getName()).append("\nId: ")
                     .append(this.getId()).append("\nAge: ")
		     .append(this.getAgeFromDateOfBirth())
		     .append("\nExperience: ").append(this.getExperienceFromDateOfJoining());
		     
	return stringBuilder.toString();
    }
}