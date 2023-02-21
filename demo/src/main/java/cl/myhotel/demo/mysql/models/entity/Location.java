package cl.myhotel.demo.mysql.models.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "locations")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Location {

    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOCATION_ID")
    private long id;

    public Location() {
    }

    public Location(String streetAddress, String postalCode, String city, String stateProvince, Country country) {
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
        this.country = country;
    }
}
