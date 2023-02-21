package cl.myhotel.demo.mysql.models.repository;

import cl.myhotel.demo.mysql.models.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatsRepository extends CrudRepository<Employee, Long> {

    @Query(
            value = "select c.COUNTRY_NAME, count(*) QUANTITY from employees e " +
                    "inner join departments d on e.DEPARTMENT_ID = d.DEPARTMENT_ID " +
                    "INNER join locations l on d.LOCATION_ID = l.LOCATION_ID " +
                    "inner join countries c on l.COUNTRY_ID = c.COUNTRY_ID " +
                    "GROUP by c.COUNTRY_NAME;",
            nativeQuery = true
    )
    List<Object> getEmployeesQuantityByCountry();

    @Query(
            value = "select c.COUNTRY_NAME, avg(e.SALARY) QUANTITY from employees e " +
                    "inner join departments d on e.DEPARTMENT_ID = d.DEPARTMENT_ID " +
                    "INNER join locations l on d.LOCATION_ID = l.LOCATION_ID " +
                    "inner join countries c on l.COUNTRY_ID = c.COUNTRY_ID " +
                    "GROUP by c.COUNTRY_NAME;",
            nativeQuery = true
    )
    List<Object> getEmployeesAvgSalaryByCountry();

    @Query(
            value = "select c.COUNTRY_NAME, max(e.SALARY) QUANTITY from employees e " +
                    "inner join departments d on e.DEPARTMENT_ID = d.DEPARTMENT_ID " +
                    "INNER join locations l on d.LOCATION_ID = l.LOCATION_ID " +
                    "inner join countries c on l.COUNTRY_ID = c.COUNTRY_ID " +
                    "GROUP by c.COUNTRY_NAME;",
            nativeQuery = true
    )
    List<Object> getEmployeesMaxSalaryByCountry();

    @Query(
            value = "select c.COUNTRY_NAME, min(e.SALARY) QUANTITY from employees e " +
                    "inner join departments d on e.DEPARTMENT_ID = d.DEPARTMENT_ID " +
                    "INNER join locations l on d.LOCATION_ID = l.LOCATION_ID " +
                    "inner join countries c on l.COUNTRY_ID = c.COUNTRY_ID " +
                    "GROUP by c.COUNTRY_NAME;",
            nativeQuery = true
    )
    List<Object> getEmployeesMinSalaryByCountry();

    @Query(
            value = "select c.COUNTRY_NAME, min((DATEDIFF(CURDATE(), HIRE_DATE) / 365)) avg_years from employees e " +
                    "inner join departments d on e.DEPARTMENT_ID = d.DEPARTMENT_ID " +
                    "INNER join locations l on d.LOCATION_ID = l.LOCATION_ID " +
                    "inner join countries c on l.COUNTRY_ID = c.COUNTRY_ID " +
                    "GROUP by c.COUNTRY_NAME;",
            nativeQuery = true
    )
    List<Object> getEmployeesAvgAntiquityByCountry();
}
