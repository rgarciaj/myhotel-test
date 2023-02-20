package cl.myhotel.demo.controllers;

import cl.myhotel.demo.models.entity.Truck;
import cl.myhotel.demo.models.service.TruckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles/trucks")
public class TruckControllers {

    private static final Logger logger = LoggerFactory.getLogger(TruckControllers.class.getSimpleName());

    private static final String COD_HTTP200 = "Successful operation";
    private static final String COD_HTTP404 = "Element does not exist";

    @Autowired
    private TruckService truckService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Truck>> getAllTrucks() throws Exception {
        logger.info("Starting getAllTrucks Service");

        List<Truck> trucks = null;
        try {
            trucks = (List<Truck>) truckService.findAll();
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        logger.info("Finishing getAllTrucks Service");
        return new ResponseEntity<List<Truck>>(trucks, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Truck> getTruckDetail(@PathVariable long id) throws Exception {
        logger.info("Starting getTruckDetail Service");

        Truck _truck = null;
        try {
            _truck = truckService.findById(id);
            if (_truck == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, COD_HTTP404);
            }
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        logger.info("Finishing getTruckDetail Service");
        return new ResponseEntity<Truck>(_truck, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> createTruck(@RequestBody Truck truck) throws Exception {
        logger.info("Starting createTruck Service");

        try {
            truckService.save(new Truck(truck.getBrand(), truck.getModel(), truck.getPatent(), truck.getYear(), truck.getMilage(), truck.getEngineCapacity(), truck.getType(), truck.getCapacity(), truck.getAxlesQuantity()));
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        logger.info("Finishing createTruck Service");
        return new ResponseEntity<String>(COD_HTTP200, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateTruck(@PathVariable long id, @RequestBody Truck truck) throws Exception {
        logger.info("Starting updateTruck Service");

        try {
            Truck _truck = truckService.findById(id);
            if (_truck == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, COD_HTTP404);
            }

            _truck.setBrand(truck.getBrand());
            _truck.setModel(truck.getModel());
            _truck.setPatent(truck.getPatent());
            _truck.setYear(truck.getYear());
            _truck.setMilage(truck.getMilage());
            _truck.setEngineCapacity(truck.getEngineCapacity());
            _truck.setType(truck.getType());
            _truck.setCapacity(truck.getCapacity());
            _truck.setAxlesQuantity(truck.getAxlesQuantity());
            truckService.save(_truck);
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        logger.info("Finishing updateTruck Service");
        return new ResponseEntity<String>(COD_HTTP200, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTruck(@PathVariable long id) throws Exception {
        logger.info("Starting deleteTruck Service");

        try {
            Truck _truck = truckService.findById(id);
            if (_truck == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, COD_HTTP404);
            }
            truckService.delete(_truck);
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        logger.info("Finishing deleteTruck Service");
        return new ResponseEntity<String>(COD_HTTP200, HttpStatus.OK);
    }
}
