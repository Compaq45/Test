package com.example.todolist.service;

import com.example.todolist.model.Message;
import com.example.todolist.model.Task;
import com.example.todolist.repo.MessageRepo;
import com.example.todolist.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepo messageRepo;
    @Autowired
    TaskRepo taskRepo;

    @Override
    public List<Message> getMessages(Long taskId)
    {
        return messageRepo.getMessagesByParent(taskId);
    }

}
