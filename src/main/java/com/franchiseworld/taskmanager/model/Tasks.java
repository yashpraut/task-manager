package com.franchiseworld.taskmanager.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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



    @Column(name = "EndDate")
    private LocalDateTime endDate;

    @Column(name = "EstimatedTime")
    private double estimatedTime;



    @Column(name = "StartDate")
    private LocalDateTime startDate;

    @Column(name = "Status")
    private String status;

    @Column(name = "TaskName")
    private String taskName;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;



    @ManyToOne
    @JsonBackReference(value="employees-tasks")
    @JoinColumn(name = "EmployeeID")
    private Employees employees;

    @ManyToOne
    @JoinColumn(name = "ProjectID")
    @JsonBackReference(value = "tasks-projects")
    private Projects projects;


    private int flag;

    // Constructors
    public Tasks() {
    }

    public Tasks(int taskID, LocalDateTime createdAt, String description, LocalDateTime endDate, double estimatedTime, LocalDateTime startDate, String status, String taskName, LocalDateTime updatedAt, Employees employees, Projects projects, int flag) {
        this.taskID = taskID;
        this.createdAt = createdAt;
        this.description = description;
        this.endDate = endDate;
        this.estimatedTime = estimatedTime;
        this.startDate = startDate;
        this.status = status;
        this.taskName = taskName;
        this.updatedAt = updatedAt;
        this.employees = employees;
        this.projects = projects;
        this.flag = flag;
    }

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



    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Projects getProjects() {
        return projects;
    }

    public void setProjects(Projects projects) {
        this.projects = projects;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

}
