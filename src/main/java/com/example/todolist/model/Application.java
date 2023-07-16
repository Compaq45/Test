package com.example.todolist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long application_id;
    @Column(name = "applicant")
    private String applicant;
    @Column(name = "filling_time")
    private Timestamp filling_time;
    @Column(name = "description")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "executor")
    private Employee executor;
    @Column(name = "pc_name")
    private String pc_name;

}
