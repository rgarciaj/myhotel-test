package cl.myhotel.demo.mysql.models.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class StatsEmployeesMinSalaryResponse {
    private String country;
    private BigDecimal minSalary;

    public StatsEmployeesMinSalaryResponse(String country, BigDecimal minSalary) {
        this.country = country;
        this.minSalary = minSalary;
    }
}
