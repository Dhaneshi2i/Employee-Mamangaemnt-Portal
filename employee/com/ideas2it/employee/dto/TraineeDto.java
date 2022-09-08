package com.ideas2it.employee.dto;

import java.util.List;

public class TraineeDto extends EmployeeDto {

    private int traineeId;
    private String reportingPersonName;  
    private List<TrainerDto> trainers;
  
    public void setTraineeId(int traineeId) {
        this.traineeId = traineeId;
    }

    public int getTraineeId() {
        return traineeId;
    }

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
	stringBuilder.append(super.toString())
                     .append("\nReporting person name: ")
		     .append(this.getReportingPersonName());

	return stringBuilder.toString();
    }
}