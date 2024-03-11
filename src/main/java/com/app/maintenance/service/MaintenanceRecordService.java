package com.app.maintenance.service;

import com.app.maintenance.model.MaintenanceRecord;
import com.app.maintenance.repository.MaintenanceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceRecordService implements MaintenanceRecordServiceInterface {

    @Autowired
    private MaintenanceRecordRepository maintenanceRecordRepository;

    public MaintenanceRecord saveMaintenanceRecord(MaintenanceRecord maintenanceRecord) {
        return maintenanceRecordRepository.save(maintenanceRecord);
    }

    // returns an Optional containing the object if found and an empty object otherwise
    // this handles null cases and NullPointerException errors
    public Optional<MaintenanceRecord> getMaintenanceRecord(Long id) {
        return maintenanceRecordRepository.findById(id);
    }

    public List<MaintenanceRecord> getAllMaintenanceRecords() {
        return maintenanceRecordRepository.findAll();
    }

    public void deleteMaintenanceRecord(Long id) {
        maintenanceRecordRepository.deleteById(id);
    }

    // Additional methods & business logic
}
