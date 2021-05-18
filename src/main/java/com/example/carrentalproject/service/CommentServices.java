package com.example.carrentalproject.service;

import com.example.carrentalproject.model.Comment;
import java.util.List;
import java.util.Optional;

public interface CommentServices {
    public List<Comment> findAll();

    public Optional<Comment> findById(int commentID);

    public int save(SaveCommentRequest saveCommentRequest);

    public void delete(int commentId);
}
