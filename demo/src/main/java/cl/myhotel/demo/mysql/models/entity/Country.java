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
@Table(name = "countries")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String countryId;
    private String countryName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "REGION_ID")
    private Region region;

    public Country() {
    }

    public Country(String countryId, String countryName, Region region) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.region = region;
    }

}
