package org.example;

public class Trainer{
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void getTrainerInfo() {
        System.out.println("role: "+this.getRole());
    }
}
