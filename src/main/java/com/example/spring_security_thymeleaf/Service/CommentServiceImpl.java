package com.example.spring_security_thymeleaf.Service;

import com.example.spring_security_thymeleaf.Model.Comment;
import com.example.spring_security_thymeleaf.Repository.CommentRepository;
import com.example.spring_security_thymeleaf.Repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final TopicRepository topicRepository;


    @Override
    public void saveComment(String author, String text, long id) {
        Comment comment = new Comment(author, text);
        comment.setTopic(topicRepository.findById(id));
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> findAllCommentsByTopic(Long id) {
        return commentRepository.findAllByTopicId(id);
    }

    @Override
    public void deleteComment(String commentId) {
        commentRepository.delete(commentRepository.findById(Long.parseLong(commentId)));
    }
}
