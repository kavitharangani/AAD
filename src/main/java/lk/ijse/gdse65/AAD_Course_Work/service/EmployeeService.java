package lk.ijse.gdse65.AAD_Course_Work.service;

import lk.ijse.gdse65.AAD_Course_Work.Exception.NotFoundException;
import lk.ijse.gdse65.AAD_Course_Work.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employee);
    boolean deleteEmployee(String id) throws NotFoundException;
    boolean updateEmployee(String id,EmployeeDTO employee) throws NotFoundException;
    List<EmployeeDTO> getAllEmployees();
//void saveEmployee(EmployeeDTO employeeDTO);
//    void updateEmployee(String id,EmployeeDTO employeeDTO);
//    boolean deleteEmployee(String id);
//    EmployeeDTO getEmployee(String id);
//    List<EmployeeDTO> getAllEmployees();
}
