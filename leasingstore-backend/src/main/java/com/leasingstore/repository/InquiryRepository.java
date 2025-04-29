package com.leasingstore.repository;

import com.leasingstore.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Inquiry entity
 */
@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
    // Additional query methods can be defined here
}
