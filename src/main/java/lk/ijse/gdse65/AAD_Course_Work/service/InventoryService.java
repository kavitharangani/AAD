package lk.ijse.gdse65.AAD_Course_Work.service;

import lk.ijse.gdse65.AAD_Course_Work.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {
    InventoryDTO saveInventory(InventoryDTO inventory);
    void deleteInventory(String id);
    void updateInventory(String id,InventoryDTO inventoryDTO);
    List<InventoryDTO> getAllInventory();
    long count();
}
