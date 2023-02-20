package cl.myhotel.demo.models.service;

import cl.myhotel.demo.models.entity.Maintenance;
import cl.myhotel.demo.models.repository.MaintenanceBaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private static final Logger logger = LoggerFactory.getLogger(MaintenanceServiceImpl.class.getSimpleName());

    @Autowired
    MaintenanceBaseRepository maintenanceBaseRepository;

    @Override
    public Iterable<Maintenance> findAll(long id) {
        Iterable<Maintenance> maintenances = maintenanceBaseRepository.findAll(id);
        return maintenances;
    }

    @Override
    public Maintenance findByVehicleId(long vehicleId) {
        Maintenance maintenances = maintenanceBaseRepository.findByVehicleId(vehicleId);
        return null;
    }
}
