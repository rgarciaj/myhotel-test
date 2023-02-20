package cl.myhotel.demo.controllers;

import cl.myhotel.demo.models.entity.Maintenance;
import cl.myhotel.demo.models.entity.Vehicle;
import cl.myhotel.demo.models.service.MaintenanceService;
import cl.myhotel.demo.models.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles/{vehicle_id}/maintenances")
public class MaintenanceControllers {

    private static final Logger logger = LoggerFactory.getLogger(CarsControllers.class.getSimpleName());

    private static final String COD_HTTP200 = "Successful operation";
    private static final String COD_HTTP404 = "Element does not exist";

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private MaintenanceService maintenanceService;

    public MaintenanceControllers(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Maintenance>> getAllMaintenance(@PathVariable long vehicle_id) {
        logger.info("Starting getAllMaintenance Service");

        Vehicle _vehicle;
        try {
            _vehicle = vehicleService.findById(vehicle_id);
            if (_vehicle == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, COD_HTTP404);
            }
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        List<Maintenance> maintenances;
        try {
            maintenances = maintenanceService.findByVehicleId(vehicle_id);
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        logger.info("Finishing getAllMaintenance Service");
        return new ResponseEntity<>(maintenances, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Maintenance> createMaintenance(@PathVariable long vehicle_id, @RequestBody Maintenance maintenance) {
        logger.info("Starting createMaintenance Service");

        Vehicle _vehicle;
        try {
            _vehicle = vehicleService.findById(vehicle_id);
            if (_vehicle == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, COD_HTTP404);
            }
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        Maintenance maintenanceCreated;
        try {
            maintenanceCreated = maintenanceService.save(vehicle_id, maintenance);
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        logger.info("Finishing createMaintenance Service");
        return new ResponseEntity<>(maintenanceCreated, HttpStatus.OK);
    }

    @RequestMapping(value = "/{maintenance_id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteMaintenance(@PathVariable long vehicle_id, @PathVariable long maintenance_id) {
        logger.info("Starting deleteMaintenance Service");

        Vehicle _vehicle;
        try {
            _vehicle = vehicleService.findById(vehicle_id);
            if (_vehicle == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, COD_HTTP404);
            }
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        Maintenance _maintenance;
        try {
            _maintenance = maintenanceService.findById(maintenance_id);
            if (_maintenance == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, COD_HTTP404);
            }
            maintenanceService.delete(_maintenance);
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        logger.info("Finishing deleteMaintenance Service");
        return new ResponseEntity<>(COD_HTTP200, HttpStatus.OK);
    }

}
