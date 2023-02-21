package cl.myhotel.demo.mysql.models.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class StatsEmployeesAvgSalaryResponse {
    private String country;
    private BigDecimal averageSalary;

    public StatsEmployeesAvgSalaryResponse(String country, BigDecimal averageSalary) {
        this.country = country;
        this.averageSalary = averageSalary;
    }
}
