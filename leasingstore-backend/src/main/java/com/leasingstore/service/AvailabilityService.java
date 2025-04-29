package com.leasingstore.service;

import com.leasingstore.entity.Availability;
import com.leasingstore.repository.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing availability calendar entries
 */
@Service
public class AvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    public List<Availability> getAvailabilityByServiceId(Long serviceId) {
        return availabilityRepository.findByServiceId(serviceId);
    }

    public Availability saveAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }
}
