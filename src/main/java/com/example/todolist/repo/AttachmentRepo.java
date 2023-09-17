package com.example.todolist.repo;

import com.example.todolist.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttachmentRepo extends JpaRepository<Attachment, Long>{
    @Query("select a from Attachment a where a.comment_id = ?1")
    List<Attachment> getAllByComment_id(Long id);
}
