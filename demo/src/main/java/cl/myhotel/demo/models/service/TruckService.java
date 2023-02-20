package cl.myhotel.demo.models.service;

import cl.myhotel.demo.models.entity.Truck;

public interface TruckService {

    Iterable<Truck> findAll();

    Truck save(Truck newCar);

    Truck findById(long id);


    void delete(Truck truck);
}
