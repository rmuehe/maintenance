package com.app.maintenance.service;

import com.app.maintenance.model.Item;
import com.app.maintenance.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    // returns an Optional containing the object if found and an empty object otherwise
    // this handles null cases and NullPointerException errors
    public Optional<Item> getItem(Long id) {
        return itemRepository.findById(id);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    // Additional methods & business logic
}
