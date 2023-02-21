package cl.myhotel.demo.mysql.models.service;

import cl.myhotel.demo.mysql.models.entity.Employee;
import cl.myhotel.demo.mysql.models.repository.EmployeeRepository;
import cl.myhotel.demo.mysql.models.responses.SegmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public SegmentResponse getQuantityBySegment(String segment) {
        return switch (segment) {
            case "A" -> new SegmentResponse("A", employeeRepository.countBySegmentA());
            case "B" -> new SegmentResponse("B", employeeRepository.countBySegmentB());
            case "C" -> new SegmentResponse("C", employeeRepository.countBySegmentC());
            default -> null;
        };
    }

    @Override
    public List<Employee> getHighestSalaryFromDepartments() {
        return employeeRepository.getHighestSalaryFromDepartments();
    }

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public List<Employee> getOldestManagers() {
        return employeeRepository.getOldestManagers();
    }
}
