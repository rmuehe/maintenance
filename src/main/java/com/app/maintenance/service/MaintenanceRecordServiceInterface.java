package com.app.maintenance.service;

import com.app.maintenance.model.MaintenanceRecord;


import java.util.List;
import java.util.Optional;

public interface MaintenanceRecordServiceInterface {
    MaintenanceRecord saveMaintenanceRecord(MaintenanceRecord maintenanceRecord);
    Optional<MaintenanceRecord> getMaintenanceRecord(Long id);
    List<MaintenanceRecord> getAllMaintenanceRecords();
    void deleteMaintenanceRecord(Long id);
}


