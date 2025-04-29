package com.leasingstore.controller;

import com.leasingstore.entity.Inquiry;
import com.leasingstore.repository.InquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing user inquiries
 */
@RestController
@RequestMapping("/api/inquiries")
public class InquiryController {

    @Autowired
    private InquiryRepository inquiryRepository;

    @GetMapping("/user/{userId}")
    public List<Inquiry> getInquiriesByUser(@PathVariable Long userId) {
        return inquiryRepository.findByUserId(userId);
    }

    @PostMapping
    public Inquiry createInquiry(@RequestBody Inquiry inquiry) {
        return inquiryRepository.save(inquiry);
    }
}
