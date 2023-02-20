package cl.myhotel.demo.controllers;

import cl.myhotel.demo.models.entity.Car;
import cl.myhotel.demo.models.entity.Maintenance;
import cl.myhotel.demo.models.service.MaintenanceService;
import cl.myhotel.demo.models.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles/maintenance")
public class MaintenanceControllers {

    private static final Logger logger = LoggerFactory.getLogger(CarsControllers.class.getSimpleName());

    private static final String COD_HTTP200 = "Successful operation";

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private MaintenanceService maintenanceService;

    @RequestMapping(value = "/{vehicle_id}", method = RequestMethod.GET)
    public ResponseEntity<List<Maintenance>> getAllMaintenance(@PathVariable long vehicle_id) throws Exception {
        logger.info("Starting getAllMaintenance Service");

        List<Maintenance> maintenances = null;
        try {
            maintenances = (List<Maintenance>) maintenanceService.findByVehicleId(vehicle_id);
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        logger.info("Finishing getAllMaintenance Service");
        return new ResponseEntity<List<Maintenance>>(maintenances, HttpStatus.OK);
    }

}
