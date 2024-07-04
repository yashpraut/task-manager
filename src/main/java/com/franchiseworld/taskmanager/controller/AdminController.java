package com.franchiseworld.taskmanager.controller;

import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.model.Projects;
import com.franchiseworld.taskmanager.model.Tasks;

import com.franchiseworld.taskmanager.service.AdminEmployeeService;
import com.franchiseworld.taskmanager.service.AdminProjectService;
import com.franchiseworld.taskmanager.service.AdminTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admin")
@RestController
public class AdminController {



    @Autowired
    private AdminEmployeeService adminEmployeeService;

    @Autowired
    private AdminProjectService adminProjectService;

    @Autowired
    private AdminTasksService adminTasksService;



//    Employees Api


    @PostMapping("/saveEmployees")
    public ResponseEntity<Employees> saveEmployeeApi(@RequestBody Employees emp){

        return new ResponseEntity<>(this.adminEmployeeService.saveEmployee(emp),HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<Employees> updateEmployeeApi(@RequestBody  Employees emp,@RequestParam("empid") int id){
        return ResponseEntity.ok(this.adminEmployeeService.updateEmployee(emp,id));
    }



//    Projects

    @PostMapping("/saveProjects")
    public ResponseEntity<Projects> saveProjectsApi(@RequestBody Projects projects){

        return new ResponseEntity<>(this.adminProjectService.saveProjects(projects),HttpStatus.CREATED);
    }

    @PutMapping("/updateProject")
    public ResponseEntity<Projects> updateProjectsApi(@RequestBody Projects project,@RequestParam("projectid") int id){

        return ResponseEntity.ok(this.adminProjectService.updateProjects(project,id));
    }
    @GetMapping("/getProject")
    public ResponseEntity<Projects> getProjectsApi(@RequestParam("projectid") int id){

        return ResponseEntity.ok(this.adminProjectService.getProjects(id));
    }
    @GetMapping("/getAllProjects")
    public ResponseEntity<List<Projects>> getAllProjectsApi(){

        return ResponseEntity.ok(this.adminProjectService.getAllProject());
    }




//    Tasks


    @PostMapping("/saveTasks")
    public ResponseEntity<Tasks> saveTasksApi(@RequestBody Tasks tasks){

        return new ResponseEntity<>(this.adminTasksService.saveTasks(tasks),HttpStatus.CREATED);
    }

    @PutMapping("/updateTask")
    public ResponseEntity<Tasks> updateTasksApi(@RequestBody Tasks tasks, @RequestParam("taskid") int id){

        return ResponseEntity.ok(this.adminTasksService.updateTasks(tasks,id));
    }
    @GetMapping("/getTask")
    public ResponseEntity<Tasks> getTasksApi(@RequestParam("taskid") int id){

        return ResponseEntity.ok(this.adminTasksService.getTask(id));
    }
    @GetMapping("/getAllTasks")
    public ResponseEntity<List<Projects>> getAllTasksApi(){

        return ResponseEntity.ok(this.adminProjectService.getAllProject());
    }








}
