package cl.myhotel.demo.vehicles.models.repository;

import cl.myhotel.demo.vehicles.models.entity.Car;
import jakarta.transaction.Transactional;

@Transactional
public interface CarRepository extends VehicleBaseRepository<Car> {

}

