package cl.myhotel.demo.models.service;

import cl.myhotel.demo.models.entity.Truck;
import cl.myhotel.demo.models.repository.TruckRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TruckServiceImpl implements TruckService {

    private static final Logger logger = LoggerFactory.getLogger(TruckServiceImpl.class.getSimpleName());

    @Autowired
    TruckRepository truckRepository;

    @Override
    @Transactional
    public Iterable<Truck> findAll() {
        Iterable<Truck> trucks = truckRepository.findAll();
        return trucks;
    }

    @Override
    public Truck save(Truck truck) {
        Truck _truck = truckRepository.save(truck);
        return _truck;
    }

    @Override
    public Truck findById(long id) {
        Optional<Truck> truck = truckRepository.findById(id);
        if (truck.isPresent()) {
            return truck.get();
        }
        return null;
    }

    @Override
    public void delete(Truck truck) {
        truckRepository.delete(truck);
    }
}
