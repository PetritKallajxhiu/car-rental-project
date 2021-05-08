package com.example.carrentalproject.service;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveBrandRequest {
    private int id;
    private String name;
}
