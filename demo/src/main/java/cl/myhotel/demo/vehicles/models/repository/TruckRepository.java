package cl.myhotel.demo.vehicles.models.repository;

import cl.myhotel.demo.vehicles.models.entity.Truck;
import jakarta.transaction.Transactional;

@Transactional
public interface TruckRepository extends VehicleBaseRepository<Truck> {

}
