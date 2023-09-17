package com.example.todolist.repo;

import com.example.todolist.model.Application;
import com.example.todolist.model.Comment;
import com.example.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {

    @Query("select c from Comment c where c.task_id= ?1")
    List<Comment> findByTaskId(Task task);

    @Query("select c from Comment c where c.application_id= ?1")
    List<Comment> findByApplicationId(Application application);

}
