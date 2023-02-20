package cl.myhotel.demo.vehicles.models.repository;

import cl.myhotel.demo.vehicles.models.entity.Maintenance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRepository extends CrudRepository<Maintenance, Long> {
    List<Maintenance> findAllByVehicleId(long vehicleId);
}
