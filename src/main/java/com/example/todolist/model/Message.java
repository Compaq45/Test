package com.example.todolist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "MESSAGES")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGE_ID")
    private Long messageId;
    @Column(name = "MESSAGE_TEXT")
    private String text;
    @Column(name = "MESSAGE_CREATE_TIMESTAMP")
    private Timestamp create_Timestamp;
    @Column(name = "TASK_ID")
    private Long parentTask;
    @Column(name = "USER_ID")
    private Long creatorID;
}
