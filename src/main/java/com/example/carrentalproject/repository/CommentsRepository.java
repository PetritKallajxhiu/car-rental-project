package com.example.carrentalproject.repository;

import com.example.carrentalproject.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Integer> {
    @Query(value = "SELECT c FROM Comment c WHERE c.carId = :id")
    List<Comment> findByCarId(@Param("id") int id);
}
