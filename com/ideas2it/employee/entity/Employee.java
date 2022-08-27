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

    @Column(name ="Name")
    private String name;

    @Column(name ="Contact_Number")
    private Long contactNumber;

    @Column(name ="Date_of_Birth")
    private LocalDate dateOfBirth;

    @Column(name ="Date_of_Joining")
    private LocalDate dateOfJoining;

    @Column(name = "Deleted", nullable  = false)
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
   
}