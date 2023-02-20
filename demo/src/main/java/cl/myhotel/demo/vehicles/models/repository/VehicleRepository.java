package cl.myhotel.demo.vehicles.models.repository;

import cl.myhotel.demo.vehicles.models.entity.Vehicle;
import jakarta.transaction.Transactional;

@Transactional
public interface VehicleRepository extends VehicleBaseRepository<Vehicle> {

}
