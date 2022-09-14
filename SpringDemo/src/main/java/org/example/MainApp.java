package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        Employee employee1 = (Employee) context.getBean("traineeBean");
        Employee employee2 = (Employee) context.getBean("trainerBean");

        Trainee trainee = context.getBean(Trainee.class);
        Trainer trainer = context.getBean(Trainer.class);
        Manager manager = context.getBean(Manager.class);
        Director director = context.getBean(Director.class);

        employee1.setId(21);
        employee1.setName("Dhanesh");
        trainee.setRole("Trainee");
        employee1.getTraineeInfo();

        employee2.setName("sanjai");
        employee2.setId(25);
        trainer.setRole("Trainer");
        employee2.getTrainerInfo();

        employee1.setName("Yuvaraj");
        employee1.setId(23);
        manager.setExperience(34);
        employee1.getManagerInfo();

        employee1.setName("Arun");
        director.setSalary(1000000);
        employee1.getDirectorInfo();
    }
}
