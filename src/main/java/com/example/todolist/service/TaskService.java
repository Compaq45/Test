package com.example.todolist.service;

import com.example.todolist.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> getTasks(); //All Task return
    void addTask(Task task); // add a new Task to DB
    void delete(Long id); // removes task from DB by ID
    void delete(Task task); // removes task from DB
    List<Task> getTasks(String keyWord); // Search tasks by keyword
    Task getTask(Long id); // get Task by ID
    void updateTask(Task task); //update Task
}
