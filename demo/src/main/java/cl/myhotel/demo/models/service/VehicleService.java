package cl.myhotel.demo.models.service;

import cl.myhotel.demo.models.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> findAll();

    Vehicle findById(long id);
}
