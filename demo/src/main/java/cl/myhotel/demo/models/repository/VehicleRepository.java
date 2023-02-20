package cl.myhotel.demo.models.repository;

import cl.myhotel.demo.models.entity.Vehicle;
import jakarta.transaction.Transactional;

@Transactional
public interface VehicleRepository extends VehicleBaseRepository<Vehicle> {

}
