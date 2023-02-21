package cl.myhotel.demo.mysql.models.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "regions")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long regionId;

    private String regionName;
}
