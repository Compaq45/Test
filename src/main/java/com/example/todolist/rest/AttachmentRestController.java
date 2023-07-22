package com.example.todolist.rest;

import com.example.todolist.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class AttachmentRestController {
    @Autowired
    AttachmentService attachmentService;
}