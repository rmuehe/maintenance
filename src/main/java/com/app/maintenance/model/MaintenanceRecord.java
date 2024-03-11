package com.app.maintenance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity// Marks as JPA entity mapped to a DB table named 'Item'
@Table(name = "maintenance_record")// Marks as JPA entity mapped to a DB table named 'maintenance_record'
@Data // Lombok generates getters, setters, toString, equals, hashCode methods
@NoArgsConstructor // Lombok no argument constructor
@AllArgsConstructor // Lombok all argument constructor
@Builder // Lombok builder pattern for simpler object creation
public class MaintenanceRecord {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // persistence provider provides automatic indexing
    private Long recordId;

    @ManyToOne // Establishes a many-to-one relationship between items and maintenance records
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne // // Establishes a many-to-one relationship between testers and maintenance records
    @JoinColumn(name = "tester_user_id")
    private User tester;

    @Column(nullable = false) // maps non-null property to column on the table
    @Temporal(TemporalType.DATE)
    private Date checkDate;

    @Column(name = "item_condition", nullable = false) // maps non-null property to column on the table
    private String item_condition;

    @Column(nullable = false) // maps non-null property to column on the table
    private String actionTaken;

    @Column // maps property to column on the table
    private String warrantyInfo;

}

