package com.example.carrentalproject.service;

import com.example.carrentalproject.model.Blog;
import com.example.carrentalproject.model.Car;

import java.util.List;
import java.util.Optional;

public interface BlogServices {
    public List<Blog> findAll();

    public List<Blog> search(String title);

    public Optional<Blog> findAllById(int blogId);

    public int save(SaveBlogRequest request);

    public void  delete (int blogId);
}
