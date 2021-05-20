package com.example.carrentalproject.service.impl;

import com.example.carrentalproject.model.Blog;

import com.example.carrentalproject.repository.BlogRepository;
import com.example.carrentalproject.service.BlogServices;
import com.example.carrentalproject.service.SaveBlogRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServicesImpl implements BlogServices {
    private BlogRepository blogRepository;

    public BlogServicesImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> search(String title){return blogRepository.search(title);}

    @Override
    public Optional<Blog> findAllById(int blogId) {
        return blogRepository.findById(blogId);
    }

    @Override
    public int save(SaveBlogRequest request) {
        var blog = blogRepository.findById(request.getId());
        if (blog.isPresent()) {
            blog.get().setAuthor(request.getAuthor());
            blog.get().setContent(request.getContent());
            blog.get().setPhoto(request.getPhoto());
            blog.get().setTitle(request.getTitle());
            blogRepository.save(blog.get());
            return blog.get().getId();
        } else {
            var newBlog = Blog.builder()
                    .title(request.getTitle())
                    .author(request.getAuthor())
                    .photo(request.getPhoto())
                    .content(request.getContent())
                    .createdAt(new Date())
                    .build();
            blogRepository.save(newBlog);
            return newBlog.getId();
        }    }

    @Override
    public void delete(int blogId) {
        var blog = blogRepository.findById(blogId).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        blogRepository.delete(blog);
    }
}
