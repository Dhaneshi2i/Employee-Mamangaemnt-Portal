package com.ideas2it.employee.entity;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
public class Trainee extends Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int traineeId;

    @Column(name ="Reporting_person_name")
    private String reportingPersonName;  

    @ManyToMany(targetEntity = Trainer.class, cascade = { CascadeType.ALL })
    @JoinTable(name = "link_employee",
               joinColumns = @JoinColumn(name= "Trainee_Id"),
               inverseJoinColumns = @JoinColumn(name = "Trainer_Id" ))
    private List<Trainer> trainers;

    public void setTrainer(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public List<Trainer> getTrainer() {
        return trainers;
    }
  
    public void setReportingPersonName(String reportingPersonName) {
	this.reportingPersonName = reportingPersonName;
    }

    public String getReportingPersonName() {
	return reportingPersonName;
    }
}