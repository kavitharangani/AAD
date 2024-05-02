package lk.ijse.gdse65.AAD_Course_Work.service;

import lk.ijse.gdse65.AAD_Course_Work.Exception.NotFoundException;
import lk.ijse.gdse65.AAD_Course_Work.dto.CustomerDTO;
import lk.ijse.gdse65.AAD_Course_Work.dto.SupplierDTO;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface SupplierService {
    SupplierDTO saveSupplier(SupplierDTO supplierDTO);
    List<SupplierDTO> getAllSuppliers();
    SupplierDTO getSelectedSupplier(String id);
    boolean deleteSupplier(String id) throws NotFoundException;
    boolean updateSupplier(String id, SupplierDTO supplierDTO) throws NotFoundException;
}
