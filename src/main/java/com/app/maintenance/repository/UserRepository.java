package com.app.maintenance.repository;

import com.app.maintenance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Spring Data JPA repository for this entity
 * This interface extends JpaRepository, providing CRUD operations and more without the need for implementation
 * Custom queries can be declared her if necessary
 * */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
