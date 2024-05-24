package lk.ijse.gdse65.AAD_Course_Work.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleInventoryDTO {
    private String orderDetailId;
    private String item_code;
    private String itemDesc;
    private int size;
    private double unitPrice;
    private int itemQty;
    private double totalPrice;
    private InventoryDTO inventory;
}
