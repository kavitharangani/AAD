package lk.ijse.gdse65.AAD_Course_Work.controller;

import lk.ijse.gdse65.AAD_Course_Work.Exception.NotFoundException;
import lk.ijse.gdse65.AAD_Course_Work.dto.EmployeeDTO;
import lk.ijse.gdse65.AAD_Course_Work.entity.Gender;
import lk.ijse.gdse65.AAD_Course_Work.entity.Role;
import lk.ijse.gdse65.AAD_Course_Work.service.EmployeeService;
import lk.ijse.gdse65.AAD_Course_Work.util.UtilMatters;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
@CrossOrigin
public class Employee {
    private final EmployeeService employeeService;

    @GetMapping("/health")
    public String checkHealth() {
        return "employee ok";
    }


    @PostMapping
    public void saveEmployee(
            @RequestParam("employeeName") String employeeName,
            @RequestParam("employeeProfilePic") String employeeProfilePic,
            @RequestParam("gender") String gender,
            @RequestParam("status") String status,
            @RequestParam("designation") String designation,
            @RequestParam("role") String role,
            @RequestParam("dob") String dob,
            @RequestParam("joinDate") String joinDate,
            @RequestParam("attachedBranch") String attachedBranch,
            @RequestParam("employeeAddress1") String employeeAddress1,
            @RequestParam("employeeAddress2") String employeeAddress2,
            @RequestParam("employeeAddress3") String employeeAddress3,
            @RequestParam("employeeAddress4") String employeeAddress4,
            @RequestParam("employeeAddress5") String employeeAddress5,
            @RequestParam("contactNo") String contactNo,
            @RequestParam("email") String email,
            @RequestParam("informInCaseOfEmergency") String informInCaseOfEmergency,
            @RequestParam("emergencyContactNo") String emergencyContactNo) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeId(UUID.randomUUID().toString());
        employeeDTO.setEmployeeName(employeeName);
        employeeDTO.setEmployeeProfilePic(UtilMatters.convertBase64(employeeProfilePic));
        employeeDTO.setGender(Gender.valueOf(gender));
        employeeDTO.setStatus(status);
        employeeDTO.setDesignation(designation);
        employeeDTO.setRole(Role.valueOf(role));
        employeeDTO.setDob(dateFormat.parse(dob));
        employeeDTO.setJoinDate(dateFormat.parse(joinDate));
        employeeDTO.setAttachedBranch(attachedBranch);
        employeeDTO.setEmployeeAddress1(employeeAddress1);
        employeeDTO.setEmployeeAddress2(employeeAddress2);
        employeeDTO.setEmployeeAddress3(employeeAddress3);
        employeeDTO.setEmployeeAddress4(employeeAddress4);
        employeeDTO.setEmployeeAddress5(employeeAddress5);
        employeeDTO.setContactNo(contactNo);
        employeeDTO.setEmail(email);
        employeeDTO.setInformInCaseOfEmergency(informInCaseOfEmergency);
        employeeDTO.setEmergencyContactNo(emergencyContactNo);

        employeeService.saveEmployee(employeeDTO);

    }

    @DeleteMapping("/{employeeId}")
    public boolean deleteEmployee(String employeeId) throws NotFoundException {
        return employeeService.deleteEmployee(employeeId);
    }

    @PatchMapping
    public boolean updateEmployee(
            @RequestPart("employeeId") String employeeId,
            @RequestPart("employeeName") String employeeName,
            @RequestPart("employeeProfilePic") String employeeProfilePic,
            @RequestPart("gender") String gender,
            @RequestPart("status") String status,
            @RequestPart("designation") String designation,
            @RequestPart("role") String role,
            @RequestPart("dob") String dob,
            @RequestPart("joinDate") String joinDate,
            @RequestPart("attachedBranch") String attachedBranch,
            @RequestPart("employeeAddress1") String employeeAddress1,
            @RequestPart("employeeAddress2") String employeeAddress2,
            @RequestPart("employeeAddress3") String employeeAddress3,
            @RequestPart("employeeAddress4") String employeeAddress4,
            @RequestPart("employeeAddress5") String employeeAddress5,
            @RequestPart("contactNo") String contactNo,
            @RequestPart("email") String email,
            @RequestPart("informInCaseOfEmergency") String informInCaseOfEmergency,
            @RequestPart("emergencyContactNo") String emergencyContactNo) throws ParseException, NotFoundException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeId(UUID.randomUUID().toString());
        employeeDTO.setEmployeeName(employeeName);
        employeeDTO.setEmployeeProfilePic(UtilMatters.convertBase64(employeeProfilePic));
        employeeDTO.setGender(Gender.valueOf(gender));
        employeeDTO.setStatus(status);
        employeeDTO.setDesignation(designation);
        employeeDTO.setRole(Role.valueOf(role));
        employeeDTO.setDob(dateFormat.parse(dob));
        employeeDTO.setJoinDate(dateFormat.parse(joinDate));
        employeeDTO.setAttachedBranch(attachedBranch);
        employeeDTO.setEmployeeAddress1(employeeAddress1);
        employeeDTO.setEmployeeAddress2(employeeAddress2);
        employeeDTO.setEmployeeAddress3(employeeAddress3);
        employeeDTO.setEmployeeAddress4(employeeAddress4);
        employeeDTO.setEmployeeAddress5(employeeAddress5);
        employeeDTO.setContactNo(contactNo);
        employeeDTO.setEmail(email);
        employeeDTO.setInformInCaseOfEmergency(informInCaseOfEmergency);
        employeeDTO.setEmergencyContactNo(emergencyContactNo);

        return employeeService.updateEmployee(employeeId,employeeDTO);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

}