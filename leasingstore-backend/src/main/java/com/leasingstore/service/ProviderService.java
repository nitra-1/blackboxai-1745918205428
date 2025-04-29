package com.leasingstore.service;

import com.leasingstore.dto.ProviderDTO;
import com.leasingstore.entity.Provider;
import com.leasingstore.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for Service Provider Module (B2B & Freelancers) - Service Listing & Management
 */
@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    public Provider getProviderById(Long id) {
        Optional<Provider> provider = providerRepository.findById(id);
        return provider.orElse(null);
    }

    public Provider createProvider(ProviderDTO providerDTO) {
        Provider provider = new Provider();
        provider.setName(providerDTO.getName());
        provider.setEmail(providerDTO.getEmail());
        provider.setPhone(providerDTO.getPhone());
        provider.setVerified(providerDTO.isVerified());
        return providerRepository.save(provider);
    }

    public Provider updateProvider(Long id, ProviderDTO providerDTO) {
        Optional<Provider> optionalProvider = providerRepository.findById(id);
        if (optionalProvider.isPresent()) {
            Provider provider = optionalProvider.get();
            provider.setName(providerDTO.getName());
            provider.setEmail(providerDTO.getEmail());
            provider.setPhone(providerDTO.getPhone());
            provider.setVerified(providerDTO.isVerified());
            return providerRepository.save(provider);
        }
        return null;
    }

    public void deleteProvider(Long id) {
        providerRepository.deleteById(id);
    }
}
