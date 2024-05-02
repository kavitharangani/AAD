package lk.ijse.gdse65.AAD_Course_Work.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
    private int user_id;
    private String user_name;
    private String email;
    private String password;
}

