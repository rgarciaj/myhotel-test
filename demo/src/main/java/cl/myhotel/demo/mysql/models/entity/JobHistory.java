package cl.myhotel.demo.mysql.models.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "job_history")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class JobHistory implements Serializable {

    @Id
    private long employeeId;
    @Id
    private String startDate;
    private String endDate;
    private long jobId;
    private long departmentId;

    public JobHistory() {
    }

    public JobHistory(long employeeId, String startDate, String endDate, long jobId, long departmentId) {
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobId = jobId;
        this.departmentId = departmentId;
    }
}
