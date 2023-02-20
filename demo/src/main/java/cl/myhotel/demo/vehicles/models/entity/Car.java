package cl.myhotel.demo.vehicles.models.entity;

import cl.myhotel.demo.vehicles.models.enums.CarTypes;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cars")
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Car extends Vehicle {

    CarTypes type;
    Integer doors;
    Integer passengers;
    Float trunkCapacity;

    public Car() {
    }

    public Car(String brand, String model, String patent, Integer year, Integer milage, Float engineCapacity, CarTypes type, Integer doors, Integer passengers, Float trunkCapacity) {
        this.brand = brand;
        this.model = model;
        this.patent = patent;
        this.year = year;
        this.milage = milage;
        this.engineCapacity = engineCapacity;

        this.type = type;
        this.doors = doors;
        this.passengers = passengers;
        this.trunkCapacity = trunkCapacity;
    }

}
