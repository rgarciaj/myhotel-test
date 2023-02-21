package cl.myhotel.demo.mysql.models.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AverageSalaryDepartmentsResponse {
    private BigDecimal departmentId;
    private BigDecimal averageSalary;

    public AverageSalaryDepartmentsResponse(BigDecimal departmentId, BigDecimal averageSalary) {
        this.departmentId = departmentId;
        this.averageSalary = averageSalary;
    }
}
