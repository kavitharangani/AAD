package lk.ijse.gdse65.AAD_Course_Work.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "inventory")
public class InventoryEntity implements SuperEntity {
    @Id
    private String item_code;
    private String item_desc;
    private int item_qty;
    @Column(columnDefinition = "LONGTEXT")
    private String item_pic;
    private String category;
    private int size;
    private double unit_price_sale;
    private double unit_price_buy;
    private double expected_profit;
    private double profit_margin;
    private String status;
}
