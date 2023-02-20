package cl.myhotel.demo.vehicles.models.service;

import cl.myhotel.demo.vehicles.models.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> findAll();

    Vehicle findById(long id);
}
