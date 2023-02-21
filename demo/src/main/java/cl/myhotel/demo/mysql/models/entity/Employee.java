package cl.myhotel.demo.mysql.models.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "employees")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Employee {

    @Column(name = "FIRST_NAME")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String firstName;
    @Column(name = "LAST_NAME")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastName;
    @Column(name = "EMAIL")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;
    @Column(name = "PHONE_NUMBER")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phoneNumber;
    @Column(name = "HIRE_DATE")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date hireDate;
    @Column(name = "SALARY")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private float salary;
    @Column(name = "COMMISSION_PCT")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private float commissionPct;
    @Column(name = "MANAGER_ID")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int managerId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "JOB_ID")
    private Job job;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    private long id;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email, String phoneNumber, Date hireDate, float salary, float commissionPct, int managerId, Department department, Job job) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.managerId = managerId;
        this.department = department;
        this.job = job;
    }

    public Employee(String firstName, String lastName, String email, String phoneNumber, Date hireDate, float salary, float commissionPct, int managerId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.managerId = managerId;
    }
}
