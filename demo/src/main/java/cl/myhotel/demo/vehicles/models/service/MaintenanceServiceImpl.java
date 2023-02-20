package cl.myhotel.demo.vehicles.models.service;

import cl.myhotel.demo.vehicles.models.entity.Maintenance;
import cl.myhotel.demo.vehicles.models.entity.Vehicle;
import cl.myhotel.demo.vehicles.models.repository.MaintenanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private static final Logger logger = LoggerFactory.getLogger(MaintenanceServiceImpl.class.getSimpleName());

    @Autowired
    MaintenanceRepository maintenanceRepository;

    @Autowired
    VehicleService vehicleRepository;

    @Override
    public List<Maintenance> findByVehicleId(long vehicleId) {
        return maintenanceRepository.findAllByVehicleId(vehicleId);
    }

    @Override
    public Maintenance save(long vehicleId, Maintenance maintenance) {
        Vehicle vehicle = vehicleRepository.findById((int) vehicleId);
        return maintenanceRepository.save(new Maintenance(maintenance.getDate(), maintenance.getMaintenanceDetail(), vehicle));
    }

    @Override
    public void delete(Maintenance maintenance) {
        maintenanceRepository.delete(maintenance);
    }

    @Override
    public Maintenance findById(long maintenanceId) {
        Optional<Maintenance> maintenance = maintenanceRepository.findById(maintenanceId);
        return maintenance.orElse(null);
    }

}
