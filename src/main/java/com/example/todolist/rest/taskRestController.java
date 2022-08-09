package com.example.todolist.rest;

import com.example.todolist.model.Task;
import com.example.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(value = "/tasks/", params = "id")
    ResponseEntity<Task> getTask(@RequestParam("id") Long taskId) {
        Task result = this.taskService.getTask(taskId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping( value = "/tasks/", params = {"id"})
    ResponseEntity<String> deleteTask(@RequestParam("id") Long taskId) {
        if(this.taskService.getTask(taskId)!=null)
        this.taskService.delete(taskId);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>("Success",HttpStatus.ACCEPTED);
    }
    @PutMapping(value = "/tasks/", params = {"name", "comment"})
    ResponseEntity<String> addTask(@RequestParam("name") String name,
                                   @RequestParam("comment") String comment)
    {
        Task task = new Task();
        task.setName(name);
        task.setComment(comment);
        this.taskService.addTask(task);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
