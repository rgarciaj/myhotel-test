package cl.myhotel.demo.mysql.models.service;

import cl.myhotel.demo.mysql.models.entity.Department;
import cl.myhotel.demo.mysql.models.responses.AverageSalaryDepartmentsResponse;
import cl.myhotel.demo.mysql.models.responses.SegmentResponse;

import java.util.List;

public interface DepartmentService {
    Department findById(int departmentId);

    SegmentResponse getQuantityBySegment(Department department, String segment);

    List<AverageSalaryDepartmentsResponse> getAverageSalaryByDepartment();

}
