package cl.myhotel.demo.mysql.models.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class StatsEmployeesMaxSalaryResponse {
    private String country;
    private BigDecimal maxSalary;

    public StatsEmployeesMaxSalaryResponse(String country, BigDecimal maxSalary) {
        this.country = country;
        this.maxSalary = maxSalary;
    }
}
