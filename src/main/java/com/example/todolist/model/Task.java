package com.example.todolist.model;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_creator", insertable = false, updatable = false)
    private Employee task_creator;
    @Column(name = "task_name")
    private String task_name;
    @Column(name = "filling_time")
    private Timestamp filling_time;
    @Column(name = "description")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "executor", insertable = false, updatable = false)
    private Employee executor;
    @Column(name = "start_date")
    private Timestamp start_date;
    @Column(name = "finish_date")
    private Timestamp finish_date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_task", insertable = false, updatable = false)
    private Task parent_task;

}
