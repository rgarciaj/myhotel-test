package cl.myhotel.demo.models.repository;

import cl.myhotel.demo.models.entity.Car;
import jakarta.transaction.Transactional;

@Transactional
public interface CarRepository extends VehicleBaseRepository<Car> {

}

