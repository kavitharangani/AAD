package lk.ijse.gdse65.AAD_Course_Work.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse65.AAD_Course_Work.Exception.NotFoundException;
import lk.ijse.gdse65.AAD_Course_Work.dto.EmployeeDTO;
import lk.ijse.gdse65.AAD_Course_Work.entity.EmployeeEntity;
import lk.ijse.gdse65.AAD_Course_Work.repo.EmployeeDAO;
import lk.ijse.gdse65.AAD_Course_Work.service.EmployeeService;
import lk.ijse.gdse65.AAD_Course_Work.util.Mapping;
import lk.ijse.gdse65.AAD_Course_Work.util.UtilMatters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeIMPL implements EmployeeService {
    private final EmployeeDAO employeeDAO;
    private final Mapping mapping;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employee) {
        employee.setEmployeeId(UUID.randomUUID().toString());
        return mapping.toEmployeeDTO(employeeDAO.save(mapping.toEmployeeEntity(employee)));
    }

    @Override
    public boolean deleteEmployee(String id) throws NotFoundException {
        Optional<EmployeeEntity> employee = employeeDAO.findById(id);
        if (employee.isPresent()) {
            employeeDAO.deleteById(id);
            return true;
        } else {
            throw new NotFoundException(id + " not found (:");
        }

    }

    @Override
    public boolean updateEmployee(String id, EmployeeDTO employeeDTO) throws NotFoundException {
        Optional<EmployeeEntity> optionalEmployee = employeeDAO.findById(id);
        if (optionalEmployee.isPresent()) {
            EmployeeEntity employee = optionalEmployee.get();
            employee.setEmployeeName(employeeDTO.getEmployeeName());
            employee.setEmployeeProfilePic(UtilMatters.convertBase64(employeeDTO.getEmployeeProfilePic()));
            employee.setGender(employeeDTO.getGender());
            employee.setStatus(employeeDTO.getStatus());
            employee.setDesignation(employeeDTO.getDesignation());
            employee.setRole(employeeDTO.getRole());
            employee.setDob(employeeDTO.getDob());
            employee.setJoinDate(employeeDTO.getJoinDate());
            employee.setAttachedBranch(employeeDTO.getAttachedBranch());
            employee.setEmployeeAddress1(employeeDTO.getEmployeeAddress1());
            employee.setEmployeeAddress2(employeeDTO.getEmployeeAddress2());
            employee.setEmployeeAddress3(employeeDTO.getEmployeeAddress3());
            employee.setEmployeeAddress4(employeeDTO.getEmployeeAddress4());
            employee.setEmployeeAddress5(employeeDTO.getEmployeeAddress5());
            employee.setContactNo(employeeDTO.getContactNo());
            employee.setEmail(employeeDTO.getEmail());
            employee.setInformInCaseOfEmergency(employeeDTO.getInformInCaseOfEmergency());
            employee.setEmergencyContactNo(employeeDTO.getEmergencyContactNo());
            return true;
        } else {
            throw new NotFoundException(id + " not found :(");
        }

    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return mapping.toEmployeeDTOList(employeeDAO.findAll());

    }
}
