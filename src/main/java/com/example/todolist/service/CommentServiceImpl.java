package com.example.todolist.service;

import com.example.todolist.model.Comment;
import com.example.todolist.model.Task;
import com.example.todolist.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;

    @Override
    public Comment getComment(Long id) {
        return commentRepo.findById(id).get();
    }

    @Override
    public List<Comment> getComments(Long task_id) {
        return commentRepo.findAll();
    }

    @Override
    public List<Comment> getComments(Task task) {
        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withIgnoreNullValues();
        Comment example = new Comment();
        example.setTask_id(task);
        return commentRepo.findAll(Example.of(example,matcher));
    }

    @Override
    public void addComment(Comment comment) {
        comment.setComment_id(null);
        comment.setCreation_time(new Timestamp(System.currentTimeMillis()));
        commentRepo.save(comment);
    }

    @Override
    public void deleteComment(Comment comment) {
        commentRepo.delete(comment);
    }

    @Override
    public void updateComment(Comment comment) {
        commentRepo.save(comment);
    }
}
