package com.example.spring_security_thymeleaf.Repository;

import com.example.spring_security_thymeleaf.Model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    Topic findById(long id);
}
