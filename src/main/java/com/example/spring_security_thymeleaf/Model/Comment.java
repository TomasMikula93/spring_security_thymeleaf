package com.example.spring_security_thymeleaf.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String author;
    private String text;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "topic")
    private Topic topic;

    public Comment(String author, String text) {
        this.text = text;
        this.author = author;
        this.date = new Date();
    }
}
