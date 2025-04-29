package com.leasingstore.controller;

import com.leasingstore.dto.ProviderDTO;
import com.leasingstore.entity.Provider;
import com.leasingstore.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Provider related operations
 */
@RestController
@RequestMapping("/api/providers")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    /**
     * Get all providers
     */
    @GetMapping
    public List<Provider> getAllProviders() {
        return providerService.getAllProviders();
    }

    /**
     * Get provider by ID
     */
    @GetMapping("/{id}")
    public Provider getProviderById(@PathVariable Long id) {
        return providerService.getProviderById(id);
    }

    /**
     * Create a new provider
     */
    @PostMapping
    public Provider createProvider(@RequestBody ProviderDTO providerDTO) {
        return providerService.createProvider(providerDTO);
    }

    /**
     * Update an existing provider
     */
    @PutMapping("/{id}")
    public Provider updateProvider(@PathVariable Long id, @RequestBody ProviderDTO providerDTO) {
        return providerService.updateProvider(id, providerDTO);
    }

    /**
     * Delete a provider
     */
    @DeleteMapping("/{id}")
    public void deleteProvider(@PathVariable Long id) {
        providerService.deleteProvider(id);
    }
}
