package cl.myhotel.demo.vehicles.controllers;

import cl.myhotel.demo.vehicles.models.entity.Vehicle;
import cl.myhotel.demo.vehicles.models.service.CarService;
import cl.myhotel.demo.vehicles.models.service.TruckService;
import cl.myhotel.demo.vehicles.models.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}