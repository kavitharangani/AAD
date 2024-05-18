package lk.ijse.gdse65.AAD_Course_Work.repo;

import lk.ijse.gdse65.AAD_Course_Work.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryDAO extends JpaRepository<InventoryEntity ,String> {
}
