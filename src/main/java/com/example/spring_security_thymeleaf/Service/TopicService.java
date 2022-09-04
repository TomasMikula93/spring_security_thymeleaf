package com.example.spring_security_thymeleaf.Service;

import com.example.spring_security_thymeleaf.Model.Topic;

import java.util.List;

public interface TopicService {
    List<Topic> findAllTopics();

    void deleteTopic(String topicId);
}
