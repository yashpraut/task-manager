package com.franchiseworld.taskmanager.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TaskID")
    private int taskID;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @Column(name = "Description")
    private String description;

    @Column(name = "EmployeeID")
    private int employeeID;

    @Column(name = "EndDate")
    private LocalDateTime endDate;

    @Column(name = "EstimatedTime")
    private double estimatedTime;

    @Column(name = "ProjectID")
    private int projectID;

    @Column(name = "StartDate")
    private LocalDateTime startDate;

    @Column(name = "Status")
    private String status;

    @Column(name = "TaskName")
    private String taskName;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

    // Constructors
    public Tasks() {
    }

    public Tasks(LocalDateTime createdAt, String description, int employeeID, LocalDateTime endDate, double estimatedTime, int projectID, LocalDateTime startDate, String status, String taskName, LocalDateTime updatedAt) {
        this.createdAt = createdAt;
        this.description = description;
        this.employeeID = employeeID;
        this.endDate = endDate;
        this.estimatedTime = estimatedTime;
        this.projectID = projectID;
        this.startDate = startDate;
        this.status = status;
        this.taskName = taskName;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public double getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(double estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // ToString method
    @Override
    public String toString() {
        return "Task{" +
                "taskID=" + taskID +
                ", createdAt=" + createdAt +
                ", description='" + description + '\'' +
                ", employeeID=" + employeeID +
                ", endDate=" + endDate +
                ", estimatedTime=" + estimatedTime +
                ", projectID=" + projectID +
                ", startDate=" + startDate +
                ", status='" + status + '\'' +
                ", taskName='" + taskName + '\'' +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
