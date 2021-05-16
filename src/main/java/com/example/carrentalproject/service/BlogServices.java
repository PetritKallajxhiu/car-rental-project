package com.example.carrentalproject.service;

import com.example.carrentalproject.model.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogServices {
    public List<Blog> findAll();

    public Optional<Blog> findAllById(int blogId);

    public int save(SaveBlogRequest request);

    public void  delete (int blogId);
}
