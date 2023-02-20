package cl.myhotel.demo.models.service;

import cl.myhotel.demo.models.entity.Car;

public interface CarService {
    Iterable<Car> findAll();

    Car save(Car car);

    Car findById(long id);

    void delete(Car car);
}
