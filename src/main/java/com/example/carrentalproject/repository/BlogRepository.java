package com.example.carrentalproject.repository;

import com.example.carrentalproject.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "SELECT b FROM Blog b WHERE b.title = :title")
    List<Blog> search(@Param("title") String title);
}
