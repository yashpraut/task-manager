package com.franchiseworld.taskmanager.serviceImpl;

import com.franchiseworld.taskmanager.customexception.ProjectNotFoundException;
import com.franchiseworld.taskmanager.customexception.TaskNotFoundException;
import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.model.Projects;
import com.franchiseworld.taskmanager.repos.ProjectsRepo;
import com.franchiseworld.taskmanager.service.AdminProjectService;
import com.franchiseworld.taskmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AdminProjectServiceImpl implements AdminProjectService {


    @Autowired
    private ProjectsRepo projectsRepo;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public Projects saveProjects(Projects projects,int id) {

        Employees employeeById = this.employeeService.getEmployeeById(projects.getEmp().getEmployeeID());

        projects.setStartDate(LocalDateTime.now());
        projects.setUpdatedAt(LocalDateTime.now());
        projects.setCreatedAt(LocalDateTime.now());
        projects.setEndDate(LocalDateTime.now());
        projects.setEmp(employeeById);
        projects.setFlag(1);
        return this.projectsRepo.save(projects);
    }

    @Override
    public Projects updateProjects(Projects projects, int id) {

        return this.projectsRepo.findById(id).map(p ->{
            projects.setProjectId(p.getProjectId());
            projects.setStartDate(p.getStartDate());
            projects.setUpdatedAt(LocalDateTime.now());
            projects.setCreatedAt(p.getCreatedAt());
            projects.setEndDate(LocalDateTime.now());
            return this.projectsRepo.save(projects);
        }).orElseThrow(() -> new ProjectNotFoundException("Project Not Found Exception!!!"));

    }

    @Override
    public Projects getProjects(int id) {
       return this.projectsRepo.findById(id).filter(e->e.getFlag()==1).orElseThrow(() -> new ProjectNotFoundException("Project Not Found Exception!!!"));

    }

    @Override
    public List<Projects> getAllProject() {
        return this.projectsRepo.findAll().stream().filter(project -> project.getFlag()==1).collect(Collectors.toList());
    }

    @Override
    public void deleteProjectById(int id) {
        this.projectsRepo.findById(id).map(
                projects -> {
                    projects.setFlag(0);
                    this.projectsRepo.save(projects);
                    return projects ;
                }
        ).orElseThrow(() -> new TaskNotFoundException("Task Not Found !!"));


    }




}
