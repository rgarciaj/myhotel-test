package cl.myhotel.demo.models.entity;

import cl.myhotel.demo.models.enums.TruckTypes;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "trucks")
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Truck extends Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    TruckTypes type;
    Float capacity;
    Integer axlesQuantity;

    public Truck() {
    }

    public Truck(String brand, String model, String patent, Integer year, Integer milage, Float engineCapacity, TruckTypes type, Float capacity, Integer axlesQuantity) {
        this.brand = brand;
        this.model = model;
        this.patent = patent;
        this.year = year;
        this.milage = milage;
        this.engineCapacity = engineCapacity;

        this.type = type;
        this.capacity = capacity;
        this.axlesQuantity = axlesQuantity;
    }

}
