
package com.mytask.platform.core.controller;

import com.mytask.platform.core.entity.CustomerProfile;
import com.mytask.platform.core.service.CustomerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerProfileController {

    private final CustomerProfileService service;

    public CustomerProfileController(CustomerProfileService service) {
        this.service = service;
    }

    @PostMapping
    public CustomerProfile createCustomerProfile(@RequestBody CustomerProfile profile) {
        return service.createCustomerProfile(profile);
    }

    @GetMapping("/{id}")
    public CustomerProfile fetchCustomerProfileById(@PathVariable String id) {
        return service.retrieveCustomerProfileById(id);
    }

    @GetMapping
    public List<CustomerProfile> fetchAllCustomerProfiles() {
        return service.retrieveAllCustomerProfiles();
    }

    @PutMapping("/{id}")
    public CustomerProfile modifyCustomerProfile(@PathVariable String id, @RequestBody CustomerProfile profile) {
        return service.updateCustomerProfile(id, profile);
    }

    @DeleteMapping("/{id}")
    public void removeCustomerProfile(@PathVariable String id) {
        service.deleteCustomerProfileById(id);
    }
}
