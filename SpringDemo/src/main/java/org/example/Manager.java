package org.example;

import org.springframework.stereotype.Component;

@Component
public class Manager {
    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    private int experience;

    public void getManagerInfo() {
        System.out.println("Experience: "+this.getExperience());
    }
}
