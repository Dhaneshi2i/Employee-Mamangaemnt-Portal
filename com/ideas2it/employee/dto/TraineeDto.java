package com.ideas2it.employee.dto;

import java.util.List;

public class TraineeDto extends EmployeeDto {

    private String reportingPersonName;  
    private List<TrainerDto> trainers;
  
    public void setReportingPersonName(String reportingPersonName) {
	this.reportingPersonName = reportingPersonName;
    }

    public String getReportingPersonName() {
	return reportingPersonName;
    }

    public void setTrainer(List<TrainerDto> trainers) {
        this.trainers = trainers;
    }

    public List<TrainerDto> getTrainer() {
        return trainers;
    }

    public String toString() {
	StringBuilder stringBuilder = new StringBuilder();
	stringBuilder.append(super.toString()).append("\nReporting person name: ")
		     .append(this.getReportingPersonName());

	return stringBuilder.toString();
    }
}