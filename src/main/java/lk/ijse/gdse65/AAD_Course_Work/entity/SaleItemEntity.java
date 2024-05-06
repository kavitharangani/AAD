package lk.ijse.gdse65.AAD_Course_Work.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SaleItem")
public class SaleItemEntity implements SuperEntity{
    @Id
    private String order_id;
}
