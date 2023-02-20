package cl.myhotel.demo.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "maintenance")
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Maintenance implements Serializable {

    private static final long serialVersionUID = 1L;
    private Date date;
    private String maintenanceDetail;
    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Vehicle vehicle;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Maintenance() {
    }

    public Maintenance(Date date, String maintenanceDetail, Vehicle vehicle) {
        this.date = date;
        this.maintenanceDetail = maintenanceDetail;
        this.vehicle = vehicle;
    }

}
