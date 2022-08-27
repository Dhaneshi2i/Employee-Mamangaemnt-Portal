package com.ideas2it.employee.entity;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "Trainees")
public class Trainee extends Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trainee_seq")
    @SequenceGenerator(name = "trainee_seq",sequenceName = "trainee_sequence")
    private int traineeId;

    @Column(name ="Reporting_person_name")
    private String reportingPersonName;  

    @ManyToMany(targetEntity = Trainer.class, cascade = { CascadeType.ALL })
    @JoinTable(name = "link_employee",
               joinColumns = {@JoinColumn(name= "Trainee_Id")},
               inverseJoinColumns = {@JoinColumn(name = "Trainer_Id" )})
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