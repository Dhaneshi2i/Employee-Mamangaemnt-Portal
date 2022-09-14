package org.example;

public class Director {

    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void getDirectorInfo(){
        System.out.println("salary: "+getSalary());
    }
}
