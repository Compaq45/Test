package com.example.todolist.rest;

import com.example.todolist.model.Message;
import com.example.todolist.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class messageRestController {
    @Autowired
    MessageService messageService;

    @GetMapping(path = "/messages", params = {"task"})
    ResponseEntity<List<Message>> getMessages(@RequestParam("task") Long taskId) {
        if(taskId==null) return null;
        List<Message> result = this.messageService.getMessages(taskId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
