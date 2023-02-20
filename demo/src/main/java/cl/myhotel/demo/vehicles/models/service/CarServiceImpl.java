package cl.myhotel.demo.vehicles.models.service;

import cl.myhotel.demo.vehicles.models.entity.Car;
import cl.myhotel.demo.vehicles.models.repository.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private static final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class.getSimpleName());

    @Autowired
    CarRepository carRepository;

    @Override
    public Iterable<Car> findAll() {
        Iterable<Car> cars = carRepository.findAll();
        return cars;
    }

    @Override
    public Car save(Car car) {
        Car _car = carRepository.save(car);
        return _car;
    }

    @Override
    public Car findById(long id) {
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent()) {
            return car.get();
        }
        return null;
    }

    @Override
    public void delete(Car car) {
        carRepository.delete(car);
    }
}
