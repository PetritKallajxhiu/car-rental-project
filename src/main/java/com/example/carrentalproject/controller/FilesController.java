package com.example.carrentalproject.controller;

import com.example.carrentalproject.service.FileService;
import com.example.carrentalproject.service.impl.FileServiceImpl;
import com.example.carrentalproject.util.UploadResponseMessage;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FilesController {
    private final FileServiceImpl fileServiceImpl;

    public FilesController(FileServiceImpl fileServiceImpl) {
        this.fileServiceImpl = fileServiceImpl;
    }

    @PostMapping
    public ResponseEntity<UploadResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        fileServiceImpl.save(file);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new UploadResponseMessage("Uploaded the file successfully: " + file.getOriginalFilename()));
    }

    @GetMapping("/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        var file = fileServiceImpl.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}
