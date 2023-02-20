package cl.myhotel.demo.controllers;

import cl.myhotel.demo.models.entity.Car;
import cl.myhotel.demo.models.entity.Truck;
import cl.myhotel.demo.models.entity.Vehicle;
import cl.myhotel.demo.models.service.CarService;
import cl.myhotel.demo.models.service.TruckService;
import cl.myhotel.demo.models.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehiclesController {

    private static final Logger logger = LoggerFactory.getLogger(VehiclesController.class.getSimpleName());

    private static final String COD_HTTP200 = "Successful operation";

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private CarService carService;

    @Autowired
    private TruckService truckService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Vehicle>> getAllVehicles() throws Exception {
        logger.info("Starting getAllVehicles Service");

        List<Vehicle> vehicles = null;
        try {
            vehicles = vehicleService.findAll();
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        logger.info("Finishing getAllVehicles Service");
        return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> createVehicle(@RequestBody Vehicle vehicle) throws Exception {
        logger.info("Starting createVehicle Service");

        try {
//            Vehicle _vehicle = vehicleService.save(new Vehicle(vehicle.getBrand(), vehicle.getModel(), vehicle.getPatent(), vehicle.getYear(), vehicle.getMilage(), vehicle.getEngineCapacity()));
//
//            if (vehicle.getCar() != null) {
//                carService.save(new Car(vehicle.getCar().getType(), vehicle.getCar().getDoors(), vehicle.getCar().getPassengers(), vehicle.getCar().getTrunkCapacity(), _vehicle));
//            }
//
//            if (vehicle.getTruck() != null) {
//                truckService.save(new Truck(vehicle.getTruck().getType(), vehicle.getTruck().getCapacity(), vehicle.getTruck().getAxlesQuantity(), _vehicle));
//            }

        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        logger.info("Finishing createVehicle Service");
        return new ResponseEntity<String>(COD_HTTP200, HttpStatus.OK);
    }
}