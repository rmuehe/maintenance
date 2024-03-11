package com.app.maintenance.service;

import com.app.maintenance.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemServiceInterface {
    Item saveItem(Item item);
    Optional<Item> getItem(Long id);
    List<Item> getAllItems();
    void deleteItem(Long id);
}
