package com.example.todolist.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "attachment")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attachment_id")
    private Long attachment_id;
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "comment_id")
    private Comment comment_id;
    @Column(name = "attachment_name")
    private String attachment_name;
    @Column(name = "attachment_type")
    private String attachment_type;
    @Column(name = "attachment_link")
    private String attachment_link;
    @Column(name = "attachment_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY HH:mm:ss")
    private Timestamp attachment_date;
}
