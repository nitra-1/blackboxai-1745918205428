package com.leasingstore.repository;

import com.leasingstore.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Service entity
 */
@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    // Additional query methods can be defined here
}
