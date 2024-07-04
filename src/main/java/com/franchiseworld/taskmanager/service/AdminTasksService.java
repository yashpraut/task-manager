package com.franchiseworld.taskmanager.service;

import com.franchiseworld.taskmanager.model.Tasks;

import java.util.List;

public interface AdminTasksService {



    public Tasks saveTasks(Tasks task);

    public Tasks updateTasks(Tasks tasks, int id);

    public Tasks getTask(int id);

    public List<Tasks> getAllTasks();


}
