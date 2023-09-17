package com.example.todolist.rest;

import com.example.todolist.model.Task;
import com.example.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(value = "Tasks",produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskRestController {
    @Autowired
    TaskService taskService;

    @GetMapping
    ResponseEntity<List<Task>> getAllTasks() {
        List<Task> result = this.taskService.getTasks();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("{id}")
    ResponseEntity<Task> getTask(@RequestParam("id") Task task)
    {
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @DeleteMapping( "{id}")
    ResponseEntity<String> deleteTask(@RequestParam("id") Long taskId) {
        if(this.taskService.getTask(taskId)!=null)
        this.taskService.delete(taskId);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }
    @PostMapping()
    ResponseEntity<Task> addTask(@RequestBody Task task)
    {
        task.setFilling_time(new Timestamp(System.currentTimeMillis()));
        task.setTask_id(null);
        this.taskService.addTask(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    ResponseEntity<Task> updateTask(@RequestBody Task task,
                                      @RequestParam("id") Task task_old )
    {
        taskService.updateTask(task_old,task);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

}
