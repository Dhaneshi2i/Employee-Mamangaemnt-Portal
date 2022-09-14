package org.example;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {

    private Trainee trainee;

    private Trainer trainer;

    @Autowired
    private Manager manager;
    @Autowired
    private Director director;

    public void setDirector(Director director){
        this.director=director;
    }

    public Employee(Trainee trainee){
        this.trainee=trainee;
    }

    public Employee(Trainer trainer){
        this.trainer=trainer;
    }
    private String name;
    private int id;

    public void setName(String name){
        this.name=name;
    }

    public void setId(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void getTrainerInfo(){
        System.out.println("Name: "+getName());
        trainer.getTrainerInfo();
    }

    public void getTraineeInfo(){
        System.out.println("Name: "+getName());
        trainee.getTraineeInfo();
    }

    public void getManagerInfo(){
        System.out.println("Name: "+getName());
        manager.getManagerInfo();
    }

    public void getDirectorInfo(){
        System.out.println("Name: "+getName());
        director.getDirectorInfo();
    }
}

