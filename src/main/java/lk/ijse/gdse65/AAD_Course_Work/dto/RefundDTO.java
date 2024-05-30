package lk.ijse.gdse65.AAD_Course_Work.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RefundDTO {
    private String refundId;
    private String description;
    private Date refundDate;
    private EmployeeDTO employee;
    private SaleDTO sale;
    private List<RefundedItemDTO> refundedItems = new ArrayList<>();
}
