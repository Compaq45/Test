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
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class taskRestController {
    @Autowired
    TaskService taskService;

    @GetMapping( "/tasks")
    ResponseEntity<List<Task>> getAllTasks() {
        List<Task> result = this.taskService.getTasks();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping(value = "/task/", params = "id")
    ResponseEntity<Task> getTask(@RequestParam("id") Long taskId) {
        Task result = this.taskService.getTask(taskId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping( value = "/task/", params = {"id"})
    ResponseEntity<String> deleteTask(@RequestParam("id") Long taskId) {
        if(this.taskService.getTask(taskId)!=null)
        this.taskService.delete(taskId);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>("Success",HttpStatus.ACCEPTED);
    }
    @PutMapping(value = "/task/")
    ResponseEntity<String> addTask(@RequestBody @Validated Task task)
    {
        task.setFilling_time(new Timestamp(System.currentTimeMillis()));
        task.setTask_id(null);
        this.taskService.addTask(task);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PatchMapping(value = "/task/")
    ResponseEntity<String> updateTask(@RequestBody @Validated Task task)
    {
        Task target=this.taskService.getTask(task.getTask_id());
        if(target!=null) {
            this.taskService.updateTask(task);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
