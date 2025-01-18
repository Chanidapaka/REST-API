package sit.int204.classicmodelsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsapi.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
