package com.example.todolist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Getter
@Setter
@Table(name = "TASK")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TASK_ID")
    private Long id;
    @Column(name = "TASK_NAME")
    private String name;
    @Column(name = "TASK_COMMENT")
    private String comment;
    @Column(name = "TASK_CREATE_DATE")
    private Date date;
}
