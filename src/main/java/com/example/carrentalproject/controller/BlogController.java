package com.example.carrentalproject.controller;

import com.example.carrentalproject.model.Blog;
import com.example.carrentalproject.service.BlogServices;
import com.example.carrentalproject.service.SaveBlogRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    private BlogServices blogServices;

    public BlogController(BlogServices blogServices) {
        this.blogServices = blogServices;
    }

    @PostMapping
    public int addBlog(@RequestBody SaveBlogRequest request) {
        return blogServices.save(request);
    }

    @GetMapping
    public List<Blog> getBlogs() {
        return blogServices.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Blog> findById(@PathVariable int id) {
        return blogServices.findAllById(id);
    }

    @PutMapping
    public int updateBlog(@Valid @RequestBody SaveBlogRequest request) {
        return blogServices.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        blogServices.delete(id);
    }
}
