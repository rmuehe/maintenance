package com.app.maintenance.service;

import com.app.maintenance.model.ItemUsage;

import java.util.List;
import java.util.Optional;

public interface ItemUsageServiceInterface {
    ItemUsage saveItemUsage(ItemUsage itemUsage);
    Optional<ItemUsage> getItemUsage(Long id);
    List<ItemUsage> getAllItemUsages();
    void deleteItemUsage(Long id);
}
