package com.example.carrentalproject.service;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveBannerRequest {
    private int id;
    private String name;
    private String photo;
}
