package com.example.spring_security_thymeleaf.Service;

import com.example.spring_security_thymeleaf.Model.Comment;

import java.util.List;

public interface CommentService {
    void saveComment(String Author, String text, long id);

    List<Comment> findAllCommentsByTopic(Long id);

    void deleteComment(String commentId);
}
