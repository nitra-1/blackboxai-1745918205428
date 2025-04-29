package com.leasingstore.repository;

import com.leasingstore.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Provider entity
 */
@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
    // Additional query methods can be defined here
}
