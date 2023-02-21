package cl.myhotel.demo.mysql.models.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "departments")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Department {

    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;
    @Column(name = "MANAGER_ID")
    private long managerId;
    @ManyToOne
    @JoinColumn(name = "LOCATION_ID")
    private Location location;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPARTMENT_ID")
    private long id;

    public Department(String departmentName, long managerId, Location location) {
        this.departmentName = departmentName;
        this.managerId = managerId;
        this.location = location;
    }
}
