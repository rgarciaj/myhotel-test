package cl.myhotel.demo.models.repository;

import cl.myhotel.demo.models.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface VehicleBaseRepository<T extends Vehicle>
        extends CrudRepository<T, Long> {

}


