package com.franchiseworld.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
public class Qualifications {


      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int qualificationID;

        private String qualificationType;
        private String institution;
        private int yearOfCompletion;
        private double percentage;


        @ManyToOne
        @JsonBackReference(value = "emp-qualifications")
        private Employees employees;

    public Qualifications() {
    }

    public Qualifications(int qualificationID, String qualificationType, String institution, int yearOfCompletion, double percentage, Employees employees) {
        this.qualificationID = qualificationID;
        this.qualificationType = qualificationType;
        this.institution = institution;
        this.yearOfCompletion = yearOfCompletion;
        this.percentage = percentage;
        this.employees = employees;
    }

    public int getQualificationID() {
        return qualificationID;
    }

    public void setQualificationID(int qualificationID) {
        this.qualificationID = qualificationID;
    }

    public String getQualificationType() {
        return qualificationType;
    }

    public void setQualificationType(String qualificationType) {
        this.qualificationType = qualificationType;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public int getYearOfCompletion() {
        return yearOfCompletion;
    }

    public void setYearOfCompletion(int yearOfCompletion) {
        this.yearOfCompletion = yearOfCompletion;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
}
