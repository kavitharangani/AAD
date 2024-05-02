package lk.ijse.gdse65.AAD_Course_Work.controller;

import lk.ijse.gdse65.AAD_Course_Work.Exception.NotFoundException;
import lk.ijse.gdse65.AAD_Course_Work.dto.SupplierDTO;
import lk.ijse.gdse65.AAD_Course_Work.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/suppliers")
@RequiredArgsConstructor
@CrossOrigin
public class Supplier{
    private final SupplierService supplierService;

    @GetMapping("/health")
    public String healthCheck() {
        return "suppliers OK";
    }

    @PostMapping
    public SupplierDTO save(@RequestBody SupplierDTO supplierDTO){
        return supplierService.saveSupplier(supplierDTO);
    }

    @PatchMapping
    public boolean update(@RequestBody SupplierDTO supplierDTO) throws NotFoundException {
        return supplierService.updateSupplier(supplierDTO.getSupplier_id(),supplierDTO);
    }

    @DeleteMapping("/{supplier_id}")
    public boolean delete(@PathVariable("supplier_id") String id) throws NotFoundException {
        return supplierService.deleteSupplier(id);
    }
}
