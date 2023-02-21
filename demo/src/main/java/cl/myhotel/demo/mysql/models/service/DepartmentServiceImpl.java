package cl.myhotel.demo.mysql.models.service;

import cl.myhotel.demo.mysql.models.entity.Department;
import cl.myhotel.demo.mysql.models.responses.AverageSalaryDepartmentsResponse;
import cl.myhotel.demo.mysql.models.responses.SegmentResponse;
import cl.myhotel.demo.mysql.models.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department findById(int departmentId) {
        return departmentRepository.findById((long) departmentId).orElse(null);
    }

    @Override
    public SegmentResponse getQuantityBySegment(Department department, String segment) {
        return switch (segment) {
            case "A" ->
                    new SegmentResponse(department.getDepartmentName(), "A", departmentRepository.countBySegmentA(department.getId()));
            case "B" ->
                    new SegmentResponse(department.getDepartmentName(), "A", departmentRepository.countBySegmentB(department.getId()));
            case "C" ->
                    new SegmentResponse(department.getDepartmentName(), "A", departmentRepository.countBySegmentC(department.getId()));
            default -> null;
        };
    }

    @Override
    public List<AverageSalaryDepartmentsResponse> getAverageSalaryByDepartment() {
        List<Object> obj = departmentRepository.getAverageSalaryByDepartment();
        List<AverageSalaryDepartmentsResponse> averageSalaryDepartmentsList = new ArrayList<>();
        for (Object o : obj) {
            Object[] data = (Object[]) o;
            averageSalaryDepartmentsList.add(new AverageSalaryDepartmentsResponse((BigDecimal) data[0], (BigDecimal) data[1]));
        }
        return averageSalaryDepartmentsList;
    }
}
