package cl.myhotel.demo.models.service;

import cl.myhotel.demo.models.entity.Maintenance;

public interface MaintenanceService {
    Iterable<Maintenance> findAll(long id);

    Object findByVehicleId(long vehicleId);
}
