package com.example.todolist.service;

import com.example.todolist.model.Attachment;
import com.example.todolist.model.Comment;
import com.example.todolist.repo.AttachmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    AttachmentRepo attachmentRepo;

    @Override
    public void addAttachment(Attachment attachment) {
        attachment.setAttachment_id(null);
        attachment.setAttachment_date(new Timestamp(System.currentTimeMillis()));
        attachmentRepo.save(attachment);
    }

    @Override
    public void deleteAttachment(Long id) {
        attachmentRepo.deleteById(id);
    }

    @Override
    public List<Attachment> getAttachment(Long id) {
        return this.attachmentRepo.getAllByComment_id(id);
    }

    @Override
    public List<Attachment> getAttachments(Comment comment)
    {
        return attachmentRepo.getAllByComment_id(comment.getComment_id());
    }


}
