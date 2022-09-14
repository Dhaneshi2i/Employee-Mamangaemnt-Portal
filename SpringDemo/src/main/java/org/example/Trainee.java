package org.example;

public class Trainee{

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void getTraineeInfo() {
        System.out.println("role: "+this.getRole());
    }
}
