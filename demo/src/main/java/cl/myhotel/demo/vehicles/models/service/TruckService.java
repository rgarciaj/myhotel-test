package cl.myhotel.demo.vehicles.models.service;

import cl.myhotel.demo.vehicles.models.entity.Truck;

public interface TruckService {

    Iterable<Truck> findAll();

    Truck save(Truck newCar);

    Truck findById(long id);

    void delete(Truck truck);
}
