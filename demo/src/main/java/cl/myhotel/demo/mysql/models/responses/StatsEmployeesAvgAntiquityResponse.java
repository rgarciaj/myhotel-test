package cl.myhotel.demo.mysql.models.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class StatsEmployeesAvgAntiquityResponse {
    private String country;
    private BigDecimal averageAntiquity;

    public StatsEmployeesAvgAntiquityResponse(String country, BigDecimal averageAntiquity) {
        this.country = country;
        this.averageAntiquity = averageAntiquity;
    }
}
