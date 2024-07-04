package com.franchiseworld.taskmanager.serviceImpl;

import com.franchiseworld.taskmanager.customexception.UserNameNotFoundException;
import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.repos.EmployeesRepo;
import com.franchiseworld.taskmanager.service.AdminEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminEmployeeServiceImpl implements AdminEmployeeService {



    @Autowired
    private EmployeesRepo employeesRepo;

    @Override
    public Employees saveEmployee(Employees emp) {

        return this.employeesRepo.save(emp);
    }

    @Override
    public Employees updateEmployee(Employees emp, int id) {

        Employees updateEmployee = this.employeesRepo.findById(id).map(
                employees -> {
                    emp.setEmployeeID(employees.getEmployeeID());
                    return this.employeesRepo.save(emp);
                }
        ).orElseThrow(
                () -> new UserNameNotFoundException("User NOt Found !!!")
        );


        return updateEmployee;
    }

    @Override
    public List<Employees> getAllEmployees(  ) {
        return this.employeesRepo.findAll();
    }

    @Override
    public Employees getEmployee(int id) {
        return this.employeesRepo.findById(id).orElseThrow(() -> new UserNameNotFoundException("User Not Found !!"));
    }
}
