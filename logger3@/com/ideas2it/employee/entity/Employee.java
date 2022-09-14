package com.ideas2it.employee.entity;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Employee {

    @Column(name ="Id",unique=true,columnDefinition="VARCHAR(64)")
    private String id;

    private String firstName;

    private String lastName;

    private Long contactNumber;

    private String companyEmailId;

    private LocalDate dateOfBirth;

    private LocalDate dateOfJoining;

    @Column(name = "isActiveEmployee", nullable  = false)
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

    public void setActiveEmployee(boolean isActiveEmployee) {

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
   
}