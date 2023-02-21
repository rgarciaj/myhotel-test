package cl.myhotel.demo.mysql.models.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class StatsEmployeesQuantityResponse {
    private String country;
    private long quantity;

    public StatsEmployeesQuantityResponse(String country, long quantity) {
        this.country = country;
        this.quantity = quantity;
    }
}
