package com.example.todolist.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Getter
@Setter
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long task_id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "task_creator", insertable = false, updatable = false)
    private Employee task_creator;
    @Column(name = "task_name")
    private String task_name;
    @Column(name = "filling_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY HH:mm:ss")
    private Timestamp filling_time;
    @Column(name = "description")
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "executor", insertable = false, updatable = false)
    private Employee executor;
    @Column(name = "start_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY HH:mm:ss")
    private Timestamp start_date;
    @Column(name = "finish_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY HH:mm:ss")
    private Timestamp finish_date;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_task", insertable = false, updatable = false)
    private Task parent_task;

}
