package cl.myhotel.demo.models.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Entity
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Vehicle {

    String brand;
    String model;
    String patent;
    Integer year;
    Integer milage;
    Float engineCapacity;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Maintenance> maintenance;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    public Vehicle() {
    }

    public Vehicle(String brand, String model, String patent, Integer year, Integer milage, Float engineCapacity) {
        this.brand = brand;
        this.model = model;
        this.patent = patent;
        this.year = year;
        this.milage = milage;
        this.engineCapacity = engineCapacity;
    }

}
