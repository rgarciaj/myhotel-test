package cl.myhotel.demo.vehicles.models.service;

import cl.myhotel.demo.vehicles.models.entity.Car;

public interface CarService {
    Iterable<Car> findAll();

    Car save(Car car);

    Car findById(long id);

    void delete(Car car);
}
