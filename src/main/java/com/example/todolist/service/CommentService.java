package com.example.todolist.service;

import com.example.todolist.model.Comment;
import com.example.todolist.model.Task;

import java.util.List;

public interface CommentService {
    Comment getComment(Long id);
    List<Comment> getComments(Long task_id);
    List<Comment> getComments(Task task);
    void addComment(Comment comment);
    void deleteComment(Comment comment);
    void updateComment(Comment comment);
}
