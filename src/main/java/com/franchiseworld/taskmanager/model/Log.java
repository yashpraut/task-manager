package com.franchiseworld.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;


//import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity

@Table(name = "logs")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LogID")
    @NotBlank
    private Long logID;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "EmployeeID")
    @NotEmpty
    private Employees employee;

    @Column(name = "LogDate")
    @NotBlank
    private LocalDate logDate;

    @Column(name = "LogInTime")
    @NotEmpty
    private LocalDateTime logInTime;

    @Column(name = "LogOutTime")
    @NotEmpty
    private LocalDateTime logOutTime;

    //no need to getter setter


    public Long getLogID() {
        return logID;
    }

    public void setLogID(Long logID) {
        this.logID = logID;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    public LocalDate getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }

    public LocalDateTime getLogInTime() {
        return logInTime;
    }

    public void setLogInTime(LocalDateTime logInTime) {
        this.logInTime = logInTime;
    }

    public LocalDateTime getLogOutTime() {
        return logOutTime;
    }

    public void setLogOutTime(LocalDateTime logOutTime) {
        this.logOutTime = logOutTime;
    }

    public Log() {
    }

    public Log(Long logID, Employees employee, LocalDate logDate, LocalDateTime logInTime, LocalDateTime logOutTime) {
        this.logID = logID;
        this.employee = employee;
        this.logDate = logDate;
        this.logInTime = logInTime;
        this.logOutTime = logOutTime;
    }
}


