package lk.ijse.gdse65.AAD_Course_Work.repo;

import lk.ijse.gdse65.AAD_Course_Work.entity.CustomerEntity;
import lk.ijse.gdse65.AAD_Course_Work.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDAO extends JpaRepository<ItemEntity, String> {
}
