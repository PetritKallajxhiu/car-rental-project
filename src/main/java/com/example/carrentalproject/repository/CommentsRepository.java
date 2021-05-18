package com.example.carrentalproject.repository;

import com.example.carrentalproject.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comment, Integer> {
}
