package cl.myhotel.demo.models.service;

import cl.myhotel.demo.models.entity.Vehicle;
import cl.myhotel.demo.models.repository.VehicleBaseRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private static final Logger logger = LoggerFactory.getLogger(VehicleServiceImpl.class.getSimpleName());

    @Override
    @Transactional
    public List<Vehicle> findAll() {
        return null;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle findById(Integer id) {
        return null;
    }


}
