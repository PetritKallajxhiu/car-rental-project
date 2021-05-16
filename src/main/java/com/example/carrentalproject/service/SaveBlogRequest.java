package com.example.carrentalproject.service;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveBlogRequest {
    private int id;
    private String title;
    private String content;
    private String author;
    private String photo;
}
