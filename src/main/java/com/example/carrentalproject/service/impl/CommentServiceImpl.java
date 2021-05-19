package com.example.carrentalproject.service.impl;

import com.example.carrentalproject.model.Comment;
import com.example.carrentalproject.repository.CommentsRepository;
import com.example.carrentalproject.service.CommentServices;
import com.example.carrentalproject.service.SaveCommentRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentServices {
    CommentsRepository commentsRepository;

    public CommentServiceImpl(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @Override
    public List<Comment> findAll() {
        return commentsRepository.findAll();
    }

    @Override
    public Optional<Comment> findById(int commentId) {
        return commentsRepository.findById(commentId);
    }

    @Override
    public int save(SaveCommentRequest request) {
        var comment = commentsRepository.findById(request.getId());
        if (comment.isPresent()) {
            comment.get().setName(request.getName());
            comment.get().setContent(request.getContent());
            comment.get().setPhoto(request.getPhoto());
            comment.get().setRate(request.getRate());
            comment.get().setCarId(request.getCarId());
            commentsRepository.save(comment.get());
            return comment.get().getId();
        } else {
            var newComment = Comment.builder()
                    .name(request.getName())
                    .content(request.getContent())
                    .photo(request.getPhoto())
                    .rate(request.getRate())
                    .carId(request.getCarId())
                    .createdAt(new Date())
                    .build();
            commentsRepository.save(newComment);
            return newComment.getId();
        }
    }

    @Override
    public void delete(int commentId) {
        var comment = commentsRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        commentsRepository.delete(comment);
    }

    @Override
    public List<Comment> findByCarId(int id) {
        return commentsRepository.findByCarId(id);
    }
}
