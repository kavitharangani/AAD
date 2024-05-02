package lk.ijse.gdse65.AAD_Course_Work.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employee")

public class EmployeeEntity implements SuperEntity {
//    @Id
//    private String employeeId;
//    private String employeeName;
//    @Column(columnDefinition = "LONGTEXT")
//    private String employeeProfilePic;
//    @Enumerated(EnumType.STRING)
//    private Gender gender;
//    private String status;
//    private String designation;
//    @Enumerated(EnumType.STRING)
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

    @Id
    private String employeeCode;
    private String employeeName;
    @Column(columnDefinition = "LONGTEXT")
    private String profilePic;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String status;
    private String designation;
    @Temporal(TemporalType.DATE)
    private java.sql.Date dateOfBirth;
    @Temporal(TemporalType.DATE)
    private Date dateOfJoin;
    private String attachedBranch;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String postalCode;
    private String contactNo;
    private String email;
    private String emergencyContactName;
    private String emergencyContact;
    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity userEntity;
}
