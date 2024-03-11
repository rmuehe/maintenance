package com.app.maintenance.model;

import jakarta.persistence.*;
import lombok.*;

@Entity // Marks as JPA entity mapped to a DB table named 'Item'
@Table(name = "item")// Marks as JPA entity mapped to a DB table named 'item'
@Data // Lombok generates getters, setters, toString, equals, hashCode methods
@NoArgsConstructor // Lombok no argument constructor
@AllArgsConstructor // Lombok all argument constructor
@Builder // Lombok builder pattern for simpler object creation
public class Item {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id") // makes sure this ID matches the column name
//    @GeneratedValue(strategy = GenerationType.AUTO) // persistence provider provides automatic indexing
    private Long itemId;

    @Column(nullable = false) // maps non-null property to column on the table
    private String name;

    @Column(nullable = false) // maps non-null property to column on the table
    private String category;

    @Column(nullable = false) // maps non-null property to column on the table
    private String status;

    @Column(name = "warranty_info") // maps property to column on the table
    private String warrantyInfo;

    @ManyToOne // Establishes a many-to-one relationship between items and users
    @JoinColumn(name = "owner_user_id") // specifies the foreign key column in the item table
    private User owner; // owner of the item
}

