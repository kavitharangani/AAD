package lk.ijse.gdse65.AAD_Course_Work.dto;

import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse65.AAD_Course_Work.entity.Gender;
import lk.ijse.gdse65.AAD_Course_Work.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class EmployeeDTO {
    private String employeeId;
    private String employeeName;
    private String employeeProfilePic;
    private Gender gender;
    private String status;
    private String designation;
    private Role role;
    private Date dob;
    private Date joinDate;
    private String attachedBranch;
    private String employeeAddress1;
    private String employeeAddress2;
    private String employeeAddress3;
    private String employeeAddress4;
    private String employeeAddress5;
    private String contactNo;
    private String email;
    private String informInCaseOfEmergency;
    private String emergencyContactNo;


    public void setRole(lk.ijse.gdse65.AAD_Course_Work.entity.Role role) {

    }
}