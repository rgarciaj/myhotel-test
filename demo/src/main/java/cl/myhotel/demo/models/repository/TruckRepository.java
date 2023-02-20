package cl.myhotel.demo.models.repository;

import cl.myhotel.demo.models.entity.Truck;
import jakarta.transaction.Transactional;

@Transactional
public interface TruckRepository extends VehicleBaseRepository<Truck> {

}
