package com.leasingstore.service;

import com.leasingstore.entity.Admin;
import com.leasingstore.entity.Service;
import com.leasingstore.entity.Review;
import com.leasingstore.repository.AdminRepository;
import com.leasingstore.repository.ServiceRepository;
import com.leasingstore.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for Admin Module - Platform Moderation & Management
 */
@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    // Admin management
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(Long id, Admin admin) {
        if (adminRepository.existsById(id)) {
            admin.setId(id);
            return adminRepository.save(admin);
        }
        return null;
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    // Moderation: Approve or reject service listings
    public Service approveService(Long serviceId) {
        Service service = serviceRepository.findById(serviceId).orElse(null);
        if (service != null) {
            service.setApproved(true);
            return serviceRepository.save(service);
        }
        return null;
    }

    public Service rejectService(Long serviceId) {
        Service service = serviceRepository.findById(serviceId).orElse(null);
        if (service != null) {
            service.setApproved(false);
            return serviceRepository.save(service);
        }
        return null;
    }

    // Moderation: Moderate reviews
    public Review moderateReview(Long reviewId, boolean approved) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review != null) {
            review.setApproved(approved);
            return reviewRepository.save(review);
        }
        return null;
    }

    // Additional admin functionalities like category management, platform metrics, promotions can be added here
}
