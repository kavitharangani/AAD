package lk.ijse.gdse65.AAD_Course_Work.entity;

import jakarta.persistence.*;
import lk.ijse.gdse65.AAD_Course_Work.controller.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sale")
public class Sale implements SuperEntity{
    @Id
    private String order_id;
    private String customer_name;
    private String item_desc;
    private int size;
    private double unit_price;
    private double item_qty;
    private double total_price;
    private Date purchase_date;
    private String payment_method;
    private double added_points;
    private String cashier_name;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
//    private Set<SaleInventoryDetail> saleDetails = new HashSet<>();
//
//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    private Customer customer;
}
