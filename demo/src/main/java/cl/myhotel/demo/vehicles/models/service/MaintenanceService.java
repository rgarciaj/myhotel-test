package cl.myhotel.demo.vehicles.models.service;

import cl.myhotel.demo.vehicles.models.entity.Maintenance;

import java.util.List;

public interface MaintenanceService {

    List<Maintenance> findByVehicleId(long vehicleId);

    Maintenance save(long vehicleId, Maintenance maintenance);

    void delete(Maintenance maintenance);

    Maintenance findById(long maintenanceId);
}
