package com.example.todolist.service;

import com.example.todolist.model.Application;
import com.example.todolist.model.Comment;
import com.example.todolist.model.Task;

import java.util.List;

public interface CommentService {
    Comment getComment(Long id);
    List<Comment> getAllComments();
    List<Comment> getCommentsByTask(Task task);
    List<Comment> getCommentsByApplication(Application application);
    void addComment(Comment comment);
    void deleteComment(Long id);
    void updateComment(Comment comment_old, Comment comment_new);
}
