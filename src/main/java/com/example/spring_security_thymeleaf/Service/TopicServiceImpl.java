package com.example.spring_security_thymeleaf.Service;

import com.example.spring_security_thymeleaf.Model.Topic;
import com.example.spring_security_thymeleaf.Repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;


    @Override
    public List<Topic> findAllTopics() {
        return topicRepository.findAll();
    }

    @Override
    public void deleteTopic(String topicId) {
        topicRepository.deleteById(Long.parseLong(topicId));
    }
}
