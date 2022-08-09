package com.example.todolist.service;

import com.example.todolist.model.Task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.todolist.repo.TaskRepo;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    TaskRepo taskRepo;
    @Override
    public List<Task> getTasks() {
        List<Task> result;
        result = taskRepo.findAll();
        return result;
    }

    @Override
    public void addTask(Task task) {
    taskRepo.save(task);
    }

    @Override
    public void delete(Long id) {
    taskRepo.deleteById(id);
    }

    @Override
    public Task getTask(Long id) {
        return taskRepo.findById(id).get();
    }
    @Override
    public List<Task> getTasks(String keyWord) {
        return taskRepo.findAll();
    }
}