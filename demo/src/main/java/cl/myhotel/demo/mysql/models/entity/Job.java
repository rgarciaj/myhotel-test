package cl.myhotel.demo.mysql.models.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "jobs")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Job {

    @Column(name = "JOB_TITLE")
    private String jobTitle;
    @Column(name = "MIN_SALARY")
    private float minSalary;
    @Column(name = "MAX_SALARY")
    private float maxSalary;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JOB_ID")
    private String id;

    public Job() {
    }

    public Job(String jobTitle, float minSalary, float maxSalary) {
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }
}
