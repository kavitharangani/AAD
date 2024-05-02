package lk.ijse.gdse65.AAD_Course_Work.entity;

import jakarta.persistence.*;
import lk.ijse.gdse65.AAD_Course_Work.controller.Inventory;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter

@Entity
@Table(name = "sale_inventory_details")
public class SaleInventoryDetail {
    @Id
    private String orderDetailID;

//    @ManyToOne(cascade = CascadeType.DETACH)
//    @JoinColumn(name = "item_code")
//    private Inventory inventory;
//
//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Sale sale;

    private String itemName;
    private int quantity;
    private double unitCost;
    private double unitPrice;
    private double subTotal;
}
