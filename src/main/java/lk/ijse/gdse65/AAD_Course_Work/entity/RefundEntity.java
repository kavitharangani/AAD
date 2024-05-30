package lk.ijse.gdse65.AAD_Course_Work.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "refund")
public class RefundEntity implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String refundId;
    private String description;
    private Date refundDate;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
    private EmployeeEntity employee;

    @OneToOne
    @JoinColumn(name = "orderNo", referencedColumnName = "order_no")
    private SaleEntity sale;

}
