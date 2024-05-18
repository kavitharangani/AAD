package lk.ijse.gdse65.AAD_Course_Work.controller;

import jakarta.validation.Valid;
import lk.ijse.gdse65.AAD_Course_Work.dto.EmployeeDTO;
import lk.ijse.gdse65.AAD_Course_Work.entity.num.Gender;
import lk.ijse.gdse65.AAD_Course_Work.entity.num.Role;
import lk.ijse.gdse65.AAD_Course_Work.service.EmployeeService;
import lk.ijse.gdse65.AAD_Course_Work.util.UtilMatters;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:63342")
public class Employee {
    private final EmployeeService employeeService;

    @GetMapping("/health")
    public String checkHealth() {
        return "employee ok";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public EmployeeDTO saveEmployee(@Valid
//                                  @RequestPart("employeeId") String employeeId,
                                    @RequestPart ("employeeName") String employeeName,
                                    @RequestPart ("employeeProfilePic") String employeeProfilePic,
                                    @RequestPart ("gender") String gender,
                                    @RequestPart ("status") String status,
                                    @RequestPart ("designation") String designation,
                                    @RequestPart ("role") String role,
                                    @RequestPart ("dob") String dob,
                                    @RequestPart ("joinDate") String joinDate,
                                    @RequestPart ("attachedBranch") String attachedBranch,
                                    @RequestPart ("employeeAddress1") String employeeAddress1,
                                    @RequestPart ("employeeAddress2") String employeeAddress2,
                                    @RequestPart ("employeeAddress3") String employeeAddress3,
                                    @RequestPart ("employeeAddress4") String employeeAddress4,
                                    @RequestPart ("employeeAddress5") String employeeAddress5,
                                    @RequestPart ("contactNo") String contactNo,
                                    @RequestPart ("email") String email,
                                    @RequestPart ("informInCaseOfEmergency") String informInCaseOfEmergency,
                                    @RequestPart ("emergencyContactNo") String emergencyContactNo,
                                    Errors errors){
        if (errors.hasFieldErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    errors.getFieldErrors().get(0).getDefaultMessage());
        }

        //Build Base64 image
        String base64ProPic = UtilMatters.convertBase64(employeeProfilePic);


        EmployeeDTO buildEmployee = new EmployeeDTO();
        buildEmployee.setEmployeeName(employeeName);
        buildEmployee.setEmployeeProfilePic(base64ProPic);
        buildEmployee.setGender(Gender.valueOf(gender));
        buildEmployee.setStatus(status);
        buildEmployee.setDesignation(designation);
        buildEmployee.setRole(Role.valueOf(role));
        buildEmployee.setDob(Date.valueOf(dob));
        buildEmployee.setJoinDate(Date.valueOf(joinDate));
        buildEmployee.setAttachedBranch(attachedBranch);
        buildEmployee.setEmployeeAddress1(employeeAddress1);
        buildEmployee.setEmployeeAddress2(employeeAddress2);
        buildEmployee.setEmployeeAddress3(employeeAddress3);
        buildEmployee.setEmployeeAddress4(employeeAddress4);
        buildEmployee.setEmployeeAddress5(employeeAddress5);
        buildEmployee.setContactNo(contactNo);
        buildEmployee.setEmail(email);
        buildEmployee.setInformInCaseOfEmergency(informInCaseOfEmergency);
        buildEmployee.setEmergencyContactNo(emergencyContactNo);

        return employeeService.saveEmployee(buildEmployee);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable String employeeId) throws ChangeSetPersister.NotFoundException {
        employeeService.deleteEmployee(employeeId);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateEmployee(@Valid
                               @RequestPart ("employeeName") String employeeName,
                               @RequestPart ("employeeProfilePic") String employeeProfilePic,
                               @RequestPart ("gender") String gender,
                               @RequestPart ("status") String status,
                               @RequestPart ("designation") String designation,
                               @RequestPart ("role") String role,
                               @RequestPart ("dob") String dob,
                               @RequestPart ("joinDate") String joinDate,
                               @RequestPart ("attachedBranch") String attachedBranch,
                               @RequestPart ("employeeAddress1") String employeeAddress1,
                               @RequestPart ("employeeAddress2") String employeeAddress2,
                               @RequestPart ("employeeAddress3") String employeeAddress3,
                               @RequestPart ("employeeAddress4") String employeeAddress4,
                               @RequestPart ("employeeAddress5") String employeeAddress5,
                               @RequestPart ("contactNo") String contactNo,
                               @RequestPart ("email") String email,
                               @RequestPart ("informInCaseOfEmergency") String informInCaseOfEmergency,
                               @RequestPart ("emergencyContactNo") String emergencyContactNo,
                               @RequestParam("employeeId") String employeeId,
                               Errors errors) throws ChangeSetPersister.NotFoundException {
        if (errors.hasFieldErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    errors.getFieldErrors().get(0).getDefaultMessage());
        }

        //Build Base64 image
        String base64ProPic = UtilMatters.convertBase64(employeeProfilePic);


        EmployeeDTO updateEmployee = new EmployeeDTO();
        updateEmployee.setEmployeeName(employeeName);
        updateEmployee.setEmployeeProfilePic(base64ProPic);
        updateEmployee.setGender(Gender.valueOf(gender));
        updateEmployee.setStatus(status);
        updateEmployee.setDesignation(designation);
        updateEmployee.setRole(Role.valueOf(role));
        updateEmployee.setDob(Date.valueOf(dob));
        updateEmployee.setJoinDate(Date.valueOf(joinDate));
        updateEmployee.setAttachedBranch(attachedBranch);
        updateEmployee.setEmployeeAddress1(employeeAddress1);
        updateEmployee.setEmployeeAddress2(employeeAddress2);
        updateEmployee.setEmployeeAddress3(employeeAddress3);
        updateEmployee.setEmployeeAddress4(employeeAddress4);
        updateEmployee.setEmployeeAddress5(employeeAddress5);
        updateEmployee.setContactNo(contactNo);
        updateEmployee.setEmail(email);
        updateEmployee.setInformInCaseOfEmergency(informInCaseOfEmergency);
        updateEmployee.setEmergencyContactNo(emergencyContactNo);

        employeeService.updateEmployee(employeeId, updateEmployee);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}