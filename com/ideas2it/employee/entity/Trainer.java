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
@Table(name = "trainers")
public class Trainer extends Employee {

    @Id
    @GeneratedValue( strategy=GenerationType.SEQUENCE, generator="trainee_seq")
    private int trainerId;

    @Column(name = "Projects_worked")
    private byte projectsWorked;

    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "trainers")
    private List<Trainee> trainees;

    public void setTrainee(List<Trainee> trainees) {
        this.trainees = trainees;
    }

    public List<Trainee> getTrainee() {
        return trainees;
    }

    public void setProjectsWorked(byte projectsWorked) {
	this.projectsWorked = projectsWorked;
    }

    public byte getProjectsWorked() {
	return projectsWorked;
    } 

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public int getTrainerId() {
        return trainerId;
    }

}