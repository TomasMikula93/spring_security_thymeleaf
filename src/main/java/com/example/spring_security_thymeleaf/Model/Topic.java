package com.example.spring_security_thymeleaf.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Topic {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private Date date;
    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<Comment> listOfComments = new ArrayList<>();

    public Topic(String name, String description) {
        this.name = name;
        this.description = description;
        this.date = new Date();
    }
}
