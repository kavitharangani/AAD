package lk.ijse.gdse65.AAD_Course_Work.service;

import lk.ijse.gdse65.AAD_Course_Work.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO saveSupplier(SupplierDTO supplierDTO);
    List<SupplierDTO> getAllSuppliers();
    SupplierDTO getSelectedSupplier(String id);
    void deleteSupplier(String id);
    void updateSupplier(String id, SupplierDTO supplierDTO);
}
