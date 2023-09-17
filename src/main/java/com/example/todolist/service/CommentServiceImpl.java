package com.example.todolist.service;

import com.example.todolist.model.Application;
import com.example.todolist.model.Comment;
import com.example.todolist.model.Task;
import com.example.todolist.repo.CommentRepo;
import com.example.todolist.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    TaskRepo taskRepo;

    @Override
    public Comment getComment(Long id) {
        return commentRepo.findById(id).get();
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepo.findAll();
    }

    @Override
    public List<Comment> getCommentsByTask(Task task) {
        return commentRepo.findByTaskId(task);
    }

    @Override
    public List<Comment> getCommentsByApplication(Application application) {
        return commentRepo.findByApplicationId(application);
    }

    @Override
    public void addComment(Comment comment) {
        comment.setComment_id(null);
        comment.setCreation_time(new Timestamp(System.currentTimeMillis()));
        commentRepo.save(comment);
    }

    @Override
    public void deleteComment(Long id)
    {
        commentRepo.deleteById(id);
    }

    @Override
    public void updateComment(Comment comment_old, Comment comment_new)
    {
        comment_old.setText(comment_new.getText());
        commentRepo.save(comment_old);
    }
}
