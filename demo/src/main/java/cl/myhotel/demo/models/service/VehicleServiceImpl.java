package cl.myhotel.demo.models.service;

import cl.myhotel.demo.models.entity.Vehicle;
import cl.myhotel.demo.models.repository.VehicleRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private static final Logger logger = LoggerFactory.getLogger(VehicleServiceImpl.class.getSimpleName());

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    @Transactional
    public List<Vehicle> findAll() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }

    @Override
    public Vehicle findById(long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if (vehicle.isPresent()) {
            return vehicle.get();
        }
        return null;
    }

}
