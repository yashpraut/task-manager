package com.franchiseworld.taskmanager.service;


import com.franchiseworld.taskmanager.model.Employees;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdminEmployeeService {


//    Create Employee
    public Employees saveEmployee(Employees emp);


    public Employees updateEmployee(Employees emp,int id);


    public List<Employees> getAllEmployees();

    public Employees getEmployee(int id);


}
