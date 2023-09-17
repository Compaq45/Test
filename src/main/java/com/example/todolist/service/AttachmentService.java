package com.example.todolist.service;

import com.example.todolist.model.Attachment;
import com.example.todolist.model.Comment;

import java.util.List;

public interface AttachmentService {
    void addAttachment(Attachment attachment);
    void deleteAttachment(Long id);
    List<Attachment> getAttachments(Comment comment);
    List<Attachment> getAttachment(Long id);
}
