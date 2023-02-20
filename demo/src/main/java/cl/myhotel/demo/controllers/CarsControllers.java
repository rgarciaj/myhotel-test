package cl.myhotel.demo.controllers;

import cl.myhotel.demo.models.entity.Car;
import cl.myhotel.demo.models.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles/cars")
public class CarsControllers {

    private static final Logger logger = LoggerFactory.getLogger(CarsControllers.class.getSimpleName());

    private static final String COD_HTTP200 = "Successful operation";
    private static final String COD_HTTP404 = "Element does not exist";

    @Autowired
    private CarService carService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Car>> getAllCars() throws Exception {
        logger.info("Starting getAllCars Service");

        List<Car> cars = null;
        try {
            cars = (List<Car>) carService.findAll();
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        logger.info("Finishing getAllCars Service");
        return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Car> getCarDetail(@PathVariable long id) throws Exception {
        logger.info("Starting getCarDetail Service");

        Car _car = null;
        try {
            _car = carService.findById(id);
            if (_car == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, COD_HTTP404);
            }
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        logger.info("Finishing getCarDetail Service");
        return new ResponseEntity<Car>(_car, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> createCar(@RequestBody Car car) throws Exception {
        logger.info("Starting createCar Service");

        try {
            Car _car = carService.save(new Car(car.getBrand(), car.getModel(), car.getPatent(), car.getYear(), car.getMilage(), car.getEngineCapacity(), car.getType(), car.getDoors(), car.getPassengers(), car.getTrunkCapacity()));
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        logger.info("Finishing createCar Service");
        return new ResponseEntity<String>(COD_HTTP200, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateCar(@PathVariable long id, @RequestBody Car car) throws Exception {
        logger.info("Starting updateCar Service");

        try {
            Car _car = carService.findById(id);
            if (_car == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, COD_HTTP404);
            }
            _car.setBrand(car.getBrand());
            _car.setModel(car.getModel());
            _car.setPatent(car.getPatent());
            _car.setYear(car.getYear());
            _car.setMilage(car.getMilage());
            _car.setEngineCapacity(car.getEngineCapacity());
            _car.setType(car.getType());
            _car.setDoors(car.getDoors());
            _car.setPassengers(car.getPassengers());
            _car.setTrunkCapacity(car.getTrunkCapacity());
            carService.save(_car);
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        logger.info("Finishing updateCar Service");
        return new ResponseEntity<String>(COD_HTTP200, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCar(@PathVariable long id) throws Exception {
        logger.info("Starting deleteCar Service");

        try {
            Car _car = carService.findById(id);
            if (_car == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, COD_HTTP404);
            }
            carService.delete(_car);
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        logger.info("Finishing deleteCar Service");
        return new ResponseEntity<String>(COD_HTTP200, HttpStatus.OK);
    }

}
