
package com.mytask.platform.core.service;

import com.mytask.platform.core.entity.CustomerProfile;
import com.mytask.platform.core.persistence.CustomerProfileRepository;
import com.mytask.platform.events.producer.CustomerEventProducer;
import com.mytask.platform.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerProfileService {

    private final CustomerProfileRepository repository;
    private final CustomerEventProducer producer;

    public CustomerProfileService(CustomerProfileRepository repository, CustomerEventProducer producer) {
        this.repository = repository;
        this.producer = producer;
    }

    public CustomerProfile createCustomerProfile(CustomerProfile profile) {
        CustomerProfile saved = repository.save(profile);
        producer.publishEvent(saved);
        return saved;
    }

    public CustomerProfile retrieveCustomerProfileById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
    }

    public List<CustomerProfile> retrieveAllCustomerProfiles() {
        return repository.findAll();
    }

    public CustomerProfile updateCustomerProfile(String id, CustomerProfile profile) {
        CustomerProfile existing = retrieveCustomerProfileById(id);
        existing.setFullName(profile.getFullName());
        existing.setEmailAddress(profile.getEmailAddress());
        return repository.save(existing);
    }

    public void deleteCustomerProfileById(String id) {
        repository.deleteById(id);
    }
}
