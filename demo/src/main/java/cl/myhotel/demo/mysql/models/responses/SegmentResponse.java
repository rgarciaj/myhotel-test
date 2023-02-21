package cl.myhotel.demo.mysql.models.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SegmentResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String departmentName;
    private String segment;
    private int quantity;

    public SegmentResponse(String segment, int quantity) {
        this.segment = segment;
        this.quantity = quantity;
    }

    public SegmentResponse(String departmentName, String segment, int quantity) {
        this.departmentName = departmentName;
        this.segment = segment;
        this.quantity = quantity;
    }
}
