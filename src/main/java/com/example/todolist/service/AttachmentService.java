package com.example.todolist.service;

import com.example.todolist.model.Attachment;
import java.util.List;

public interface AttachmentService {
    void addAttachment(Attachment attachment);
    void deleteAttachment(Long id);
    void deleteAttachment(Attachment attachment);
    List<Attachment> getAttachment();
    Attachment getAttachment(Long id);
}
