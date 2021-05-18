package com.example.carrentalproject.controller;

import com.example.carrentalproject.model.Comment;
import com.example.carrentalproject.service.CommentServices;
import com.example.carrentalproject.service.SaveCommentRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private CommentServices commentServices;

    public CommentController(final CommentServices commentServices) {
        this.commentServices = commentServices;
    }

    @PostMapping
    public int addComment(@RequestBody SaveCommentRequest request) {
        return commentServices.save(request);
    }

    @GetMapping
    public List<Comment> getComments() {
        return commentServices.findAll();
    }

    @GetMapping("/{commentId}")
    public Optional<Comment> findById(@PathVariable int commentId) {
        return commentServices.findById(commentId);
    }

    @PutMapping
    public int updateComment(@Valid @RequestBody SaveCommentRequest request) {
        return commentServices.save(request);
    }

    @DeleteMapping("/{commentId}")
    public void delete(@PathVariable int commentId) {
        commentServices.delete(commentId);
    }
}
