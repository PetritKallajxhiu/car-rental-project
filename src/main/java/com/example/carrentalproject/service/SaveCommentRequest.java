package com.example.carrentalproject.service;

import com.example.carrentalproject.model.Car;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveCommentRequest {

    private int id;
    private String name;
    private String content;
    private int rate;
    private String photo;
    private Car car;
    private int carId;
}
