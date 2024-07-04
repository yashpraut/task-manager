package com.franchiseworld.taskmanager.serviceImpl;

import com.franchiseworld.taskmanager.customexception.TaskNotFoundException;
import com.franchiseworld.taskmanager.model.Tasks;
import com.franchiseworld.taskmanager.repos.TaskRepo;
import com.franchiseworld.taskmanager.service.AdminTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminTasksServiceImpl implements AdminTasksService {



    @Autowired
    private TaskRepo taskRepo;

    @Override
    public Tasks saveTasks(Tasks task) {
        return this.taskRepo.save(task);
    }

    @Override
    public Tasks updateTasks(Tasks tasks, int id) {
      return this.taskRepo.findById(id).map(
              t->{
                  tasks.setTaskID(t.getTaskID());
                  return taskRepo.save(tasks);
              }
      ).orElseThrow(() -> new TaskNotFoundException("Task Not Found !!!"));
    }

    @Override
    public Tasks getTask(int id) {
        return null;
    }

    @Override
    public List<Tasks> getAllTasks() {
        return null;
    }
}
