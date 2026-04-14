
package com.mytask.platform.core.persistence;

import com.mytask.platform.core.entity.CustomerProfile;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CustomerProfileRepository {

    private final Map<String, CustomerProfile> database = new HashMap<>();

    public CustomerProfile save(CustomerProfile profile) {
        database.put(profile.getCustomerId(), profile);
        return profile;
    }

    public Optional<CustomerProfile> findById(String id) {
        return Optional.ofNullable(database.get(id));
    }

    public List<CustomerProfile> findAll() {
        return new ArrayList<>(database.values());
    }

    public void deleteById(String id) {
        database.remove(id);
    }
}
