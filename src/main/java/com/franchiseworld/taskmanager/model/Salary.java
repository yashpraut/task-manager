package com.franchiseworld.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salaryID;
    private double salary;
    @OneToOne
    @JsonBackReference(value = "emp-salary")
    private  Employees employees;

    public Salary() {
    }

    public Salary(int salaryID, double salary, Employees employees) {
        this.salaryID = salaryID;
        this.salary = salary;
        this.employees = employees;
    }

    public int getSalaryID() {
        return salaryID;
    }

    public void setSalaryID(int salaryID) {
        this.salaryID = salaryID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
}
