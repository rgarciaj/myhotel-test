package cl.myhotel.demo.mysql.controllers;

import cl.myhotel.demo.mysql.models.entity.Department;
import cl.myhotel.demo.mysql.models.responses.AverageSalaryDepartmentsResponse;
import cl.myhotel.demo.mysql.models.responses.SegmentResponse;
import cl.myhotel.demo.mysql.models.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentsControllers {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentsControllers.class.getSimpleName());

    private static final String COD_HTTP404 = "Element does not exist";

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/{department_id}/segments/{segment}", method = RequestMethod.GET)
    public ResponseEntity<SegmentResponse> getQuantityBySegment(@PathVariable int department_id, @PathVariable String segment) {
        logger.info("Starting getQuantityBySegment Service");

        Department _department;
        SegmentResponse _segment;

        try {
            _department = departmentService.findById(department_id);
            if (_department == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, COD_HTTP404);
            }
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        try {
            _segment = departmentService.getQuantityBySegment(_department, segment);
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }


        logger.info("Finishing getQuantityBySegment Service");
        return new ResponseEntity<>(_segment, HttpStatus.OK);
    }

    @RequestMapping(value = "/avg-salary", method = RequestMethod.GET)
    public ResponseEntity<List<AverageSalaryDepartmentsResponse>> getAverageSalary() {
        logger.info("Starting getOldestManagers Service");

        List<AverageSalaryDepartmentsResponse> _avgSalaries;

        try {
            _avgSalaries = departmentService.getAverageSalaryByDepartment();
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        logger.info("Finishing getOldestManagers Service");
        return new ResponseEntity<>(_avgSalaries, HttpStatus.OK);
    }
}
