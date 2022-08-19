package com.example.todolist.repo;

import com.example.todolist.model.Message;
import com.example.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MessageRepo extends JpaRepository<Message, Long> {
    @Query("SELECT m FROM Message m where m.parentTask.id= :taskid")
    List<Message> getMessagesByParent(@Param("taskid")Long taskid);
}
