package com.example.todolist.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employee_id;
    @Column(name = "family_name")
    private String family_name;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "second_name")
    private String second_name;
    @Column(name = "position")
    private String position;
    @Column(name = "added")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY HH:mm:ss")
    private Timestamp added_timestamp;
}
