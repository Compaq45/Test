package com.example.todolist.service;

import com.example.todolist.model.Message;
import com.example.todolist.model.Task;

import java.util.List;

public interface MessageService {
    List<Message> getMessages(Long taskId); // get messages for taskId
}
