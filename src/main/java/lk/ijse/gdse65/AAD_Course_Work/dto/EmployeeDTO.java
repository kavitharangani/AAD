package lk.ijse.gdse65.AAD_Course_Work.dto;

import lk.ijse.gdse65.AAD_Course_Work.entity.num.Gender;
import lk.ijse.gdse65.AAD_Course_Work.entity.num.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
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

}