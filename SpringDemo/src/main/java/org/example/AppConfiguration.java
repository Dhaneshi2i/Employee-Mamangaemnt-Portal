package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfiguration {

    @Bean(name="traineeBean")
    public Employee employee1(){
        return new Employee(traineeBeam());
    }

    @Bean(name="trainerBean")
    public Employee employee(){
        return new Employee(trainerBeam());
    }
    @Bean
    public Trainee traineeBeam(){
        return new Trainee();
    }

    @Bean
    public Trainer trainerBeam(){
        return new Trainer();
    }

    @Bean
    public Director directorBeam(){
        return new Director();
    }
}
