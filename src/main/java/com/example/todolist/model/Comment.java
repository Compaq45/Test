package com.example.todolist.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long comment_id;
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "comment_creator")
    private Employee comment_creator;
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "task_id")
    private Task task_id;
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "application_id")
    private Application application_id;
    @Column(name = "text")
    private String text;
    @Column(name = "creation_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY HH:mm:ss")
    private Timestamp creation_time;
}
