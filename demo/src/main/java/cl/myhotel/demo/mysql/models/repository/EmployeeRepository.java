package cl.myhotel.demo.mysql.models.repository;

import cl.myhotel.demo.mysql.models.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Query("select count(e) from Employee e where e.salary < 3500")
    int countBySegmentA();

    @Query("select count(e) from Employee e where e.salary >= 3500 and e.salary <= 8000")
    int countBySegmentB();

    @Query("select count(e) from Employee e where e.salary > 8000")
    int countBySegmentC();

    //@Query("select e from Employee e "
    //        + "join (select emp.department emp_department, MAX(emp.salary) emp_salary from Employee emp group by emp.emp_department) t "
    //        + "on t.emp_department = e.department and t.emp_salary = e.salary"
    //)
    @Query(
            value = "select emp.* from employees emp join (select e.DEPARTMENT_ID dep, MAX(e.SALARY) MAX_SALARY from employees e group by e.DEPARTMENT_ID) t on t.dep = emp.DEPARTMENT_ID and t.MAX_SALARY = emp.SALARY;",
            nativeQuery = true
    )
    List<Employee> getHighestSalaryFromDepartments();

    @Query(
            value = "select * from employees e where HIRE_DATE < (curdate()-INTERVAL 15 YEAR)",
            nativeQuery = true
    )
    List<Employee> getOldestManagers();
}
