package com.app.maintenance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "item_usage")// Marks as JPA entity mapped to a DB table named 'item_usage'
@Data // Lombok generates getters, setters, toString, equals, hashCode methods
@NoArgsConstructor // Lombok no argument constructor
@AllArgsConstructor // Lombok all argument constructor
@Builder // Lombok builder pattern for simpler object creation
public class ItemUsage {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // persistence provider provides automatic indexing
    private Long usageId;

    @ManyToOne // Establishes a many-to-one relationship between items and item_usages
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne // // Establishes a many-to-one relationship between users and item-usages
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false) // maps non-null property to column on the table
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(nullable = false) // maps non-null property to column on the table
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "item_condition", nullable = false) // maps non-null property to column on the table
    private String itemCondition;

    @Column(nullable = false) // maps non-null property to column on the table
    private String status;

}

