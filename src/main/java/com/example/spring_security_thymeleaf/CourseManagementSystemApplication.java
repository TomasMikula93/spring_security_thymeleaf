package com.example.spring_security_thymeleaf;

import com.example.spring_security_thymeleaf.Model.Comment;
import com.example.spring_security_thymeleaf.Model.Role;
import com.example.spring_security_thymeleaf.Model.Topic;
import com.example.spring_security_thymeleaf.Model.User;
import com.example.spring_security_thymeleaf.Repository.CommentRepository;
import com.example.spring_security_thymeleaf.Repository.TopicRepository;
import com.example.spring_security_thymeleaf.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class CourseManagementSystemApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final TopicRepository topicRepository;
    private final CommentRepository commentRepository;

    public static void main(String[] args) {
        SpringApplication.run(CourseManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // setUp for testing
        Role role1 = new Role("ROLE_USER");
        Role role2 = new Role("ROLE_ADMIN");
        userRepository.save(new User("admin",
                "admin", "Iam@Admin.com",
                new BCryptPasswordEncoder().encode("password"), List.of(role1,role2)));

        Topic topic = new Topic("Java",
                "Discussion about your experiences from Java Spring Boot");
        topicRepository.save(topic);

        Comment comment = new Comment("Tom","Tak to jsem opravdu nečekal.");
        commentRepository.save(comment);

        comment.setTopic(topic);
        topic.setListOfComments(List.of(comment));
        topicRepository.save(topic);
        commentRepository.save(comment);

    }
}
