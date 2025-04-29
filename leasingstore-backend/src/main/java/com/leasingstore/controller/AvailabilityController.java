package com.leasingstore.controller;

import com.leasingstore.entity.Availability;
import com.leasingstore.repository.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing availability calendar for services
 */
@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @GetMapping("/service/{serviceId}")
    public List<Availability> getAvailabilityByService(@PathVariable Long serviceId) {
        return availabilityRepository.findByServiceId(serviceId);
    }

    @PostMapping
    public Availability addOrUpdateAvailability(@RequestBody Availability availability) {
        return availabilityRepository.save(availability);
    }
}
