package com.example.carrentalproject.service;

import com.example.carrentalproject.util.FileUploadException;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void save(MultipartFile file) throws FileUploadException;

    Resource load(String filename);
}
