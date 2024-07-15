package com.franchiseworld.taskmanager.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
@Entity
public class TaskUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long updateID;
    private String updateDescription;
    private String status;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private Date updateDate;

    @ManyToOne
    private Tasks task;

    @ManyToOne
    private Employees updatedBy;

    @ManyToOne
    private Projects project;

    public TaskUpdate(Long updateID, String updateDescription, String status, LocalDateTime startedAt, LocalDateTime endedAt, Date updateDate, Tasks task, Employees updatedBy, Projects project) {
        this.updateID = updateID;
        this.updateDescription = updateDescription;
        this.status = status;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.updateDate = updateDate;
        this.task = task;
        this.updatedBy = updatedBy;
        this.project = project;
    }

    public Long getUpdateID() {
        return updateID;
    }

    public void setUpdateID(Long updateID) {
        this.updateID = updateID;
    }

    public String getUpdateDescription() {
        return updateDescription;
    }

    public void setUpdateDescription(String updateDescription) {
        this.updateDescription = updateDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Tasks getTask() {
        return task;
    }

    public void setTask(Tasks task) {
        this.task = task;
    }

    public Employees getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Employees updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Projects getProject() {
        return project;
    }

    public void setProject(Projects project) {
        this.project = project;
    }
}