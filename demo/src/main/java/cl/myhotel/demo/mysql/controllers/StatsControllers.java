package cl.myhotel.demo.mysql.controllers;

import cl.myhotel.demo.mysql.models.responses.StatsResponse;
import cl.myhotel.demo.mysql.models.service.StatsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/stats")
public class StatsControllers {

    private static final Logger logger = LoggerFactory.getLogger(StatsControllers.class.getSimpleName());

    @Autowired
    private StatsService statsService;

    @RequestMapping(value = "/by-country", method = RequestMethod.GET)
    public ResponseEntity<StatsResponse> getStatsByCountry() {
        logger.info("Starting getStatsByCountry Service");

        StatsResponse stats;

        try {
            stats = statsService.getStats();
        } catch (Exception e) {
            logger.error("Error in getStatsByCountry Service", e);
            throw e;
        }

        logger.info("Finishing getStatsByCountry Service");
        return new ResponseEntity<>(stats, HttpStatus.OK);
    }

}
