package com.example.carrentalproject.service;

import com.example.carrentalproject.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentServices {
    List<Comment> findAll();

    Optional<Comment> findById(int commentID);

    int save(SaveCommentRequest saveCommentRequest);

    void delete(int commentId);

    List<Comment> findByCarId(int id);
}
