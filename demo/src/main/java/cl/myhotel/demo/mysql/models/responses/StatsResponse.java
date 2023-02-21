package cl.myhotel.demo.mysql.models.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class StatsResponse {
    private List<StatsEmployeesQuantityResponse> employeesQuantity;
    private List<StatsEmployeesAvgSalaryResponse> employeesAvgSalary;
    private List<StatsEmployeesMaxSalaryResponse> employeesMaxSalary;
    private List<StatsEmployeesMinSalaryResponse> employeesMinSalary;
    private List<StatsEmployeesAvgAntiquityResponse> employeesAvgAntiquity;

    public StatsResponse(List<StatsEmployeesQuantityResponse> employeesQuantity, List<StatsEmployeesAvgSalaryResponse> employeesAvgSalary, List<StatsEmployeesMaxSalaryResponse> employeesMaxSalary, List<StatsEmployeesMinSalaryResponse> employeesMinSalary, List<StatsEmployeesAvgAntiquityResponse> employeesAvgAntiquity) {
        this.employeesQuantity = employeesQuantity;
        this.employeesAvgSalary = employeesAvgSalary;
        this.employeesMaxSalary = employeesMaxSalary;
        this.employeesMinSalary = employeesMinSalary;
        this.employeesAvgAntiquity = employeesAvgAntiquity;
    }

}
