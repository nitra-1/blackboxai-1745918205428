package com.leasingstore.controller;

import com.leasingstore.entity.Admin;
import com.leasingstore.entity.Service;
import com.leasingstore.entity.Review;
import com.leasingstore.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Admin Module - Platform Moderation & Management
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Admin management endpoints
    @GetMapping("/admins")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/admins/{id}")
    public Admin getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    @PostMapping("/admins")
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    @PutMapping("/admins/{id}")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        return adminService.updateAdmin(id, admin);
    }

    @DeleteMapping("/admins/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
    }

    // Moderation endpoints
    @PostMapping("/services/{serviceId}/approve")
    public Service approveService(@PathVariable Long serviceId) {
        return adminService.approveService(serviceId);
    }

    @PostMapping("/services/{serviceId}/reject")
    public Service rejectService(@PathVariable Long serviceId) {
        return adminService.rejectService(serviceId);
    }

    @PostMapping("/reviews/{reviewId}/moderate")
    public Review moderateReview(@PathVariable Long reviewId, @RequestParam boolean approved) {
        return adminService.moderateReview(reviewId, approved);
    }

    // Additional endpoints for category management, platform metrics, promotions can be added here
}
