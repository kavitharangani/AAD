package lk.ijse.gdse65.AAD_Course_Work.repo;

import lk.ijse.gdse65.AAD_Course_Work.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<CustomerEntity, String> {
}
