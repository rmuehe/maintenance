package com.app.maintenance.service;

import com.app.maintenance.model.ItemUsage;
import com.app.maintenance.repository.ItemUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemUsageService  {

    @Autowired
    private ItemUsageRepository itemUsageRepository;

    public ItemUsage saveItemUsage(ItemUsage itemUsage) {
        return itemUsageRepository.save(itemUsage);
    }

    // returns an Optional containing the object if found and an empty object otherwise
    // this handles null cases and NullPointerException errors
    public Optional<ItemUsage> getItemUsage(Long id) {
        return itemUsageRepository.findById(id);
    }

    public List<ItemUsage> getAllItemUsages() {
        return itemUsageRepository.findAll();
    }

    public void deleteItemUsage(Long id) {
        itemUsageRepository.deleteById(id);
    }

    // Additional methods & business logic
}
