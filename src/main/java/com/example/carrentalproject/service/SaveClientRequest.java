package com.example.carrentalproject.service;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveClientRequest {

    private int id;
    private String name;
    private String email;
    private String phoneNumber;
}
