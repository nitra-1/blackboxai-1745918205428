package com.leasingstore.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * Controller for handling provider service media uploads
 */
@RestController
@RequestMapping("/api/provider/media")
public class ProviderMediaController {

    // This is a stub implementation. In a real app, you would save files to storage and update DB.

    @PostMapping("/upload")
    public ResponseEntity<String> uploadMedia(@RequestParam("serviceId") Long serviceId,
                                              @RequestParam("files") List<MultipartFile> files) {
        // TODO: Implement file saving logic
        return new ResponseEntity<>("Files uploaded successfully for serviceId: " + serviceId, HttpStatus.OK);
    }
}
