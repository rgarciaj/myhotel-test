package cl.myhotel.demo.models.repository;

import cl.myhotel.demo.models.entity.Maintenance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MaintenanceBaseRepository<T extends Maintenance>
        extends CrudRepository<T, Long> {

    Iterable<Maintenance> findAll(long id);

    Maintenance findByVehicleId(long vehicleId);
}
