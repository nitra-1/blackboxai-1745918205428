package com.leasingstore.repository;

import com.leasingstore.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Review entity
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Additional query methods can be defined here
}
