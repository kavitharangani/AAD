package lk.ijse.gdse65.AAD_Course_Work.dto;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import lk.ijse.gdse65.AAD_Course_Work.entity.Gender;
import lk.ijse.gdse65.AAD_Course_Work.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class EmployeeDTO {
//    private String employeeId;
//    private String employeeName;
//    private String employeeProfilePic;
//    private Gender gender;
//    private String status;
//    private String designation;
//    private Role role;
//    private Date dob;
//    private Date joinDate;
//    private String attachedBranch;
//    private String employeeAddress1;
//    private String employeeAddress2;
//    private String employeeAddress3;
//    private String employeeAddress4;
//    private String employeeAddress5;
//    private String contactNo;
//    private String email;
//    private String informInCaseOfEmergency;
//    private String emergencyContactNo;
//
//
//    public void setRole(lk.ijse.gdse65.AAD_Course_Work.entity.Role role) {
//
//    }
    @Null(message = "Employee code generate by the program")
    private String employeeCode;
    @NotBlank(message = "Employee name cannot be blank")
    @Size(min = 2, max = 50, message = "Employee name must be between 2 and 50 characters")
    private String employeeName;
    private String profilePic;
    @NotNull(message = "Gender cannot be null")
    private Gender gender;
    @NotNull(message = "Status cannot be null")
    private String status;
    @NotNull(message = "Designation cannot be null")
    private String designation;
    @Past(message = "Date of birth should be in the past")
    @NotNull(message = "Date of birth cannot be null")
    private java.sql.Date dateOfBirth;
    @NotNull(message = "Join date cannot be null")
    @PastOrPresent(message = "Join date must be in the past or present")
    private Date dateOfJoin;
    @NotBlank(message = "Attached Branch cannot be blank")
    private String attachedBranch;
    @NotBlank(message = "Address 1 cannot be blank")
    private String address1;
    @NotBlank(message = "Address 2 cannot be blank")
    private String address2;
    @NotBlank(message = "Address 3 cannot be blank")
    private String address3;
    @NotBlank(message = "Address 4 cannot be blank")
    private String address4;
    @NotBlank(message = "Postal code cannot be blank")
    @Pattern(regexp = "\\d{5}", message = "Postal code must be 5 digits")
    private String postalCode;
    @NotBlank(message = "Contact No cannot be blank")
    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Invalid contact number format")
    private String contactNo;
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
    private String email;
    @NotBlank(message = "Emergency Contact Name cannot be blank")
    private String emergencyContactName;
    @NotBlank(message = "Emergency Contact No cannot be blank")
    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Invalid Emergency contact number format")
    private String emergencyContact;
}