package cl.myhotel.demo.mysql.models.repository;

import cl.myhotel.demo.mysql.models.entity.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {

    @Query("select count(e) from Employee e inner join e.department d where d.id = ?1 and e.salary < 3500")
    int countBySegmentA(long id);

    @Query("select count(e) from Employee e inner join e.department d where d.id = ?1 and e.salary >= 3500 and e.salary <= 8000")
    int countBySegmentB(long id);

    @Query("select count(e) from Employee e inner join e.department d where d.id = ?1 and e.salary > 8000")
    int countBySegmentC(long id);

    @Query(
            value = "select DEPARTMENT_ID, avg(SALARY) AVERAGE_SALARY " +
                    "from employees e " +
                    "group by DEPARTMENT_ID " +
                    "having count(*) > 10",
            nativeQuery = true
    )
    List<Object> getAverageSalaryByDepartment();
}
