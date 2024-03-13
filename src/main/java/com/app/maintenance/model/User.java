package com.app.maintenance.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity // Marks as JPA entity mapped to a DB table named 'Item'
@Table(name = "user")
@Data // Lombok generates getters, setters, toString, equals, hashCode methods
@NoArgsConstructor // Lombok no argument constructor
@AllArgsConstructor // Lombok all argument constructor
@Builder // Lombok builder pattern for simpler object creation
public class User {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // database provides automatic indexing
    private Long userId;

    @Column(nullable = false) // maps non-null property to column on the table
    private String name;

    @Column // (nullable = false)
    private String contactInfo;

    @Column(nullable = false) // maps non-null property to column on the table
    private String loginCredentials;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false) // maps property to column on the table
    private Role role; // Enum for user roles like admin, user, tester

    @OneToMany(mappedBy = "owner") // Establishes a one-to-many relationship between users and items
    private List<Item> ownedItems; // owner of the item

}

