package com.ideas2it.employee.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery (name = "get_all_trainees",
                 query = "from Trainee where isActiveEmployee = :isActiveEmployee"),
    @NamedQuery (name = "get_trainee_by_id",
                 query = "from Trainee where isActiveEmployee = :isActiveEmployee AND id = :id") })
public class Trainee extends Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int traineeId;

    private String reportingPersonName;  

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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