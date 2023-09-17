package com.example.todolist.rest;

import com.example.todolist.model.Application;
import com.example.todolist.model.Comment;
import com.example.todolist.model.Task;
import com.example.todolist.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(value = "/Comment", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommentRestController {
    @Autowired
    CommentService commentService;

    @GetMapping( )
    ResponseEntity<List<Comment>> getAllComments(@RequestParam(required = false, value = "taskid") Task task,
                                                 @RequestParam(required = false, value = "applicationid") Application application) {
        List<Comment> result;
        if (task.getTask_id()!=null)
            result = this.commentService.getCommentsByTask(task);
        else
            result = this.commentService.getCommentsByApplication(application);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(params = "{id}")
    ResponseEntity<Comment> getComment(@RequestParam("commentId") Comment comment) {
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<String> addComment(@RequestBody Comment comment)
    {
        comment.setCreation_time(new Timestamp(System.currentTimeMillis()));
        this.commentService.addComment(comment);
        return new ResponseEntity<>("Added",HttpStatus.ACCEPTED);
    }

    @DeleteMapping(params = {"id"})
    ResponseEntity<String> deleteComment(@RequestParam("id") Long id)
    {
        this.commentService.deleteComment(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    @PutMapping("{id}")
    ResponseEntity<Comment> updateTask(@RequestBody Comment comment,
                                    @RequestParam("id") Comment comment_old )
    {
        commentService.updateComment(comment_old,comment);
        return new ResponseEntity<>(comment_old, HttpStatus.OK);
    }
}
