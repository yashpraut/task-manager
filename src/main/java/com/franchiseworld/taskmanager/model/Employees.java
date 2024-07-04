package com.franchiseworld.taskmanager.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;



@Entity(name = "employees")
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID")
    private int employeeID;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "MiddleName")
    private String middleName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Email",unique = true)
    private String email;

    @Column(name = "UserName",unique = true)
    private String userName;

    @Column(name = "Password")
    private String password;

    @Column(name = "Position")
    private String position;

    @Column(name = "ProfilePicture")
    private String profilePicture;

    @Column(name = "Contact_No",unique = true)
    private String contactNo;

    @Column(name = "Address")
    private String address;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "BirthDate")
    private LocalDateTime birthDate;

    @Column(name = "CreatedAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    // Default constructor
    public Employees() {
    }

    // Constructor with all fields
    public Employees(int employeeID, String firstName, String middleName, String lastName, String email, String userName, String password, String position, String profilePicture, String contactNo, String address, String gender, LocalDateTime birthDate, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.position = position;
        this.profilePicture = profilePicture;
        this.contactNo = contactNo;
        this.address = address;
        this.gender = gender;
        this.birthDate = birthDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


}
