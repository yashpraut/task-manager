package com.franchiseworld.taskmanager.controller;

import com.franchiseworld.taskmanager.message.ApiSuccess;
import com.franchiseworld.taskmanager.message.ResponseStructure;
import com.franchiseworld.taskmanager.model.*;

import com.franchiseworld.taskmanager.modeldto.EmployeeDto;
import com.franchiseworld.taskmanager.service.AdminAssignmentService;
import com.franchiseworld.taskmanager.service.AdminEmployeeService;
import com.franchiseworld.taskmanager.service.AdminProjectService;
import com.franchiseworld.taskmanager.service.AdminTasksService;
import com.franchiseworld.taskmanager.serviceImpl.AdminAssignmentServiceImpl;
import com.franchiseworld.taskmanager.serviceImpl.TaskUpdateServiceImpl;
import jakarta.validation.Valid;
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

    @Autowired
    private TaskUpdateServiceImpl service;


    @Autowired
    private AdminAssignmentService adminAssignmentService;

//    Employees Api


    @PostMapping("/saveEmployees")
    public ResponseEntity<Employees> saveEmployeeApi(@RequestBody Employees emp){

        return new ResponseEntity<>(this.adminEmployeeService.saveEmployee(emp),HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployee/{empid}")
    public ResponseEntity<Employees> updateEmployeeApi(@RequestBody EmployeeDto emp, @PathVariable("empid") int id){
        return ResponseEntity.ok(this.adminEmployeeService.updateEmployee(emp,id));
    }



//    Projects

    @PostMapping("/saveProjects/{id}")
    public ResponseEntity<Projects> saveProjectsApi(@RequestBody Projects projects,@PathVariable("id") int id){

        return new ResponseEntity<>(this.adminProjectService.saveProjects(projects,id),HttpStatus.CREATED);
    }

    @PutMapping("/updateProject/{projectid}")
    public ResponseEntity<Projects> updateProjectsApi(@RequestBody Projects project,@PathVariable("projectid") int id){

        return ResponseEntity.ok(this.adminProjectService.updateProjects(project,id));
    }
    @GetMapping("/getProject/{projectid}")
    public ResponseEntity<Projects> getProjectsApi(@PathVariable("projectid") int id){

        return ResponseEntity.ok(this.adminProjectService.getProjects(id));
    }
    @GetMapping("/getAllProjects")
    public ResponseEntity<List<Projects>> getAllProjectsApi(){

        return ResponseEntity.ok(this.adminProjectService.getAllProject());
    }
    @DeleteMapping("/deleteProjectById/{id}")
    public ResponseEntity<ApiSuccess> deleteProjectById(@PathVariable("id")  int id){
        this.adminProjectService.deleteProjectById(id);
        ApiSuccess apiSuccess = new ApiSuccess(HttpStatus.OK.value(), "Project Delete Succesfully !!");
        return new ResponseEntity<>(apiSuccess,HttpStatus.OK);
    }




    @PostMapping(value = "/saveTasks/{projectid}/{empid}")
    public ResponseEntity<Tasks> saveTasksApi(@RequestBody Tasks tasks,@PathVariable("projectid") int projectid,@PathVariable("empid") int empid){

        return new ResponseEntity<>(this.adminTasksService.saveTasks(tasks,projectid,empid),HttpStatus.CREATED);
    }

    @PutMapping("/updateTask/{taskid}/{projectid}/{empid}")
    public ResponseEntity<Tasks> updateTasksApi(@RequestBody Tasks tasks, @PathVariable("taskid") int id,@PathVariable("projectid") int projectid,@PathVariable("empid") int employeeid){

        return ResponseEntity.ok(this.adminTasksService.updateTasks(tasks,id,projectid,employeeid));
    }
    @GetMapping("/getTask/{taskid}")
    public ResponseEntity<Tasks> getTasksApi(@PathVariable("taskid") int id){

        return ResponseEntity.ok(this.adminTasksService.getTask(id));
    }
    @GetMapping("/getAllTasks")
    public ResponseEntity<List<Projects>> getAllTasksApi(){

        return ResponseEntity.ok(this.adminProjectService.getAllProject());
    }

    @DeleteMapping("/deleteTaskById/{id}")
    public ResponseEntity<ApiSuccess> deleteTaskById(@PathVariable("id") int id){
        this.adminTasksService.deleteTaskById(id);
        ApiSuccess apiSuccess = new ApiSuccess(HttpStatus.OK.value(), "Task Delete Succesfully !!");
        return new ResponseEntity<>(apiSuccess,HttpStatus.OK);
    }



    @PostMapping("/saveTaskUpdate")
    public ResponseEntity<ResponseStructure<TaskUpdate>> saveTaskUpdate(@Valid @RequestBody TaskUpdate task) {
        return service.saveTaskUpdate(task);

    }

    @GetMapping("/fetchTaskUpdate")
    public ResponseEntity<ResponseStructure<TaskUpdate>> findTaskUpdateId(@RequestParam long id) {
        return service.findTaskUpdate(id);
    }



    @GetMapping("/fetchallTaskUpdate")
    public ResponseEntity<ResponseStructure<List<TaskUpdate>>> findAllTaskUpdate() {
        return service.findAllTaskUpdate();
    }

    @DeleteMapping("/deleteTaskUpdate/{id}")
    public ResponseEntity<ResponseStructure<TaskUpdate>> deleteTaskUpdate(@PathVariable long id) {
        return service.deleteTaskUpdate(id);
    }

    @PutMapping("/updateTaskUpdate")
    public ResponseEntity<ResponseStructure<TaskUpdate>> updateTask(@RequestBody TaskUpdate task, @RequestParam
    long id) {
        return service.updateTaskUpdate(task, id);
    }



    @PostMapping("/saveAssignment")
    public ResponseEntity<Assignment> saveAssignment(@RequestBody Assignment assignment){
        Assignment assignment1 = this.adminAssignmentService.saveAssignment(assignment);
        return new ResponseEntity<Assignment>( assignment1,HttpStatus.CREATED);

    }

    @GetMapping("/getAssignment/{assignid}")
    public ResponseEntity<Assignment> getAssignmentApi(@PathVariable("assignid") int id){

        return ResponseEntity.ok(this.adminAssignmentService.getAssgnment(id));
    }
    @GetMapping("/getAllAssignment")
    public ResponseEntity<List<Assignment>> getAllAssignmentApi(){

        return ResponseEntity.ok(this.adminAssignmentService.getAllAssignments());
    }
 @PutMapping("/updateAssignment/{id}")
    public ResponseEntity<Assignment> updateAssignment(@RequestBody Assignment assignment,@PathVariable  int id){

     Assignment assignment1 = this.adminAssignmentService.ReviewTaskAssigment(assignment, id);
     return new ResponseEntity<Assignment>( assignment1,HttpStatus.OK);
 }

 @DeleteMapping("/deleteAssignment/{id}")
    public  ResponseEntity<ApiSuccess> approveAssignment(@PathVariable int id){
        this.adminAssignmentService.approveAssignment(id);
     ApiSuccess apiSuccess = new ApiSuccess(HttpStatus.OK.value(), "Assignment Approve Succesfully !!");

     return new ResponseEntity<ApiSuccess>(apiSuccess ,HttpStatus.OK);
 }




}
