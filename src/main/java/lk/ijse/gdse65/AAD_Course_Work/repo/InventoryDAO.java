package lk.ijse.gdse65.AAD_Course_Work.repo;

import lk.ijse.gdse65.AAD_Course_Work.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryDAO extends JpaRepository<InventoryEntity ,String> {
    @Query("SELECT SUM(i.unit_price_sale * i.item_qty) FROM InventoryEntity i")
    Double findTotalSales();
}

