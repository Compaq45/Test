package com.example.todolist.repo;

import com.example.todolist.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepo extends JpaRepository<Attachment, Long>{
}
