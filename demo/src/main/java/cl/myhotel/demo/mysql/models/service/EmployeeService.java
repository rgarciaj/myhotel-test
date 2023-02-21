package cl.myhotel.demo.mysql.models.service;

import cl.myhotel.demo.mysql.models.entity.Employee;
import cl.myhotel.demo.mysql.models.responses.SegmentResponse;

import java.util.List;

public interface EmployeeService {
    SegmentResponse getQuantityBySegment(String segment);

    List<Employee> getHighestSalaryFromDepartments();

    List<Employee> findAll();

    List<Employee> getOldestManagers();
}
