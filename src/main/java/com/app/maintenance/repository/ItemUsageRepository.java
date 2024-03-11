package com.app.maintenance.repository;

import com.app.maintenance.model.ItemUsage;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Spring Data JPA repository for this entity
 * This interface extends JpaRepository, providing CRUD operations and more without the need for implementation
 * Custom queries can be declared her if necessary
 * */
public interface ItemUsageRepository extends JpaRepository<ItemUsage, Long> {
}
