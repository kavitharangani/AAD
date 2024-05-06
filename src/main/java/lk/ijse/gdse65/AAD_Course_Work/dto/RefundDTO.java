package lk.ijse.gdse65.AAD_Course_Work.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RefundDTO {
    @Id
    private String refundId;
    private String description;
    private Date refundDate;

}
