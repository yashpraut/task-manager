package com.franchiseworld.taskmanager.serviceImpl;

import com.franchiseworld.taskmanager.customexception.ProjectNotFoundException;
import com.franchiseworld.taskmanager.model.Projects;
import com.franchiseworld.taskmanager.repos.ProjectsRepo;
import com.franchiseworld.taskmanager.service.AdminProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class AdminProjectServiceImpl implements AdminProjectService {


    @Autowired
    private ProjectsRepo projectsRepo;


    @Override
    public Projects saveProjects(Projects projects) {
        projects.setStartDate(LocalDateTime.now());
        projects.setUpdatedAt(LocalDateTime.now());
        projects.setCreatedAt(LocalDateTime.now());
        projects.setEndDate(LocalDateTime.now());
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
       return this.projectsRepo.findById(id).orElseThrow(() -> new ProjectNotFoundException("Project Not Found Exception!!!"));

    }

    @Override
    public List<Projects> getAllProject() {
        return this.projectsRepo.findAll();
    }
}
