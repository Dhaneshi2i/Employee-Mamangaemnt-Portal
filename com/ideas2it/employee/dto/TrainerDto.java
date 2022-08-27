package com.ideas2it.employee.dto;

import java.util.List;

public class TrainerDto extends EmployeeDto {

    private byte projectsWorked;
    private List<TraineeDto> trainees;

    public void setProjectsWorked(byte projectsWorked) {
	this.projectsWorked = projectsWorked;
    }

    public byte getProjectsWorked() {
	return projectsWorked;
    } 

    public void setTrainee(List<TraineeDto> trainees) {
        this.trainees = trainees;
    }

    public List<TraineeDto> getTrainee() {
        return trainees;
    }

    public String toString() {
	StringBuilder stringBuilder = new StringBuilder();
	stringBuilder.append(super.toString()).append("\nProjects worked: ")
		     .append(this.getProjectsWorked());

	return stringBuilder.toString();
    }
}