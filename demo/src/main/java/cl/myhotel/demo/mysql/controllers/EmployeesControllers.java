package cl.myhotel.demo.mysql.controllers;

import cl.myhotel.demo.mysql.models.entity.Employee;
import cl.myhotel.demo.mysql.models.responses.SegmentResponse;
import cl.myhotel.demo.mysql.models.service.EmployeeService;
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
@RequestMapping(value = "/employees")
public class EmployeesControllers {

    private static final Logger logger = LoggerFactory.getLogger(EmployeesControllers.class.getSimpleName());

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getAllEmployees() {
        logger.info("Starting getAllEmployees Service");

        List<Employee> _employees;

        try {
            _employees = employeeService.findAll();
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        logger.info("Finishing getAllEmployees Service");
        return new ResponseEntity<>(_employees, HttpStatus.OK);
    }

    @RequestMapping(value = "/segments/{segment}", method = RequestMethod.GET)
    public ResponseEntity<SegmentResponse> getQuantityBySegment(@PathVariable String segment) {
        logger.info("Starting getQuantityBySegment Service");

        SegmentResponse _segment;

        try {
            _segment = employeeService.getQuantityBySegment(segment);
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        logger.info("Finishing getQuantityBySegment Service");
        return new ResponseEntity<>(_segment, HttpStatus.OK);
    }

    @RequestMapping(value = "/highest-salary-from-departments", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getHighestSalaryFromDepartments() {
        logger.info("Starting getHighestSalaryFromDepartments Service");

        List<Employee> _employees;

        try {
            _employees = employeeService.getHighestSalaryFromDepartments();
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        logger.info("Finishing getHighestSalaryFromDepartments Service");
        // TODO: retorna error, no arma el JSON ya que no hace la relación con las entities Department y Job
        return new ResponseEntity<>(_employees, HttpStatus.OK);
    }

    @RequestMapping(value = "/oldest-managers", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getOldestManagers() {
        logger.info("Starting getOldestManagers Service");

        List<Employee> _employees;

        try {
            _employees = employeeService.getOldestManagers();
        } catch (Exception e) {
            logger.error(e.getClass().toString() + " " + e.getMessage());
            throw e;
        }

        logger.info("Finishing getOldestManagers Service");
        // TODO: retorna error, no arma el JSON ya que no hace la relación con las entities Department y Job
        return new ResponseEntity<>(_employees, HttpStatus.OK);
    }



}
