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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TASK_ID")
    private Task parent;
}
