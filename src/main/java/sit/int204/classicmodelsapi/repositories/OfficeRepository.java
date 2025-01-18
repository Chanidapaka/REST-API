package sit.int204.classicmodelsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsapi.entities.Office;

public interface OfficeRepository extends JpaRepository<Office, String> {
}
