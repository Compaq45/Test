package com.example.todolist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
}
