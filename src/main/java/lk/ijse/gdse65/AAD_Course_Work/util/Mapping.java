package lk.ijse.gdse65.AAD_Course_Work.util;

import lk.ijse.gdse65.AAD_Course_Work.dto.*;
import lk.ijse.gdse65.AAD_Course_Work.entity.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Mapping {
    private final ModelMapper mapper;

    //****************** Customer *****************
    public CustomerDTO toCustomerDTO(CustomerEntity customer) {
        return  mapper.map(customer, CustomerDTO.class);
    }
    public CustomerEntity toCustomer(CustomerDTO customerDTO) {
        return  mapper.map(customerDTO, CustomerEntity.class);
    }
    public List<CustomerDTO> toCustomerDTOList(List<CustomerEntity> customers) {
        return mapper.map(customers, List.class);
    }

    //****************** Supplier ******************
    public SupplierDTO toSupplierDTO(SupplierEntity supplier) {
        return  mapper.map(supplier, SupplierDTO.class);
    }
    public SupplierEntity toSupplierEntity(SupplierDTO supplierDTO) {
        return  mapper.map(supplierDTO, SupplierEntity.class);
    }
    public List<SupplierDTO> toSupplierDTOList(List<SupplierEntity> suppliers) {
        return mapper.map(suppliers, List.class);
    }

    //****************** Employee ******************
    public EmployeeDTO toEmployeeDTO (EmployeeEntity employee){
        return mapper.map(employee,EmployeeDTO.class);
    }
    public EmployeeEntity toEmployeeEntity (EmployeeDTO employeeDTO){
        return mapper.map(employeeDTO,EmployeeEntity.class);
    }
    public List<EmployeeDTO> toEmployeeDTOList (List<EmployeeEntity> employees){
        return mapper.map(employees,List.class);
    }

    //****************** Inventory ******************
    public InventoryDTO toInventoryDTO(InventoryEntity inventory){
        return mapper.map(inventory,InventoryDTO.class);
    }
    public InventoryEntity toIventoryEntity(InventoryDTO inventoryDTO){
        return mapper.map(inventoryDTO,InventoryEntity.class);
    }
    public List<InventoryDTO> toInventoryDTOList(List<InventoryEntity> inventories){
        return mapper.map(inventories,List.class);
    }

    //****************** Item ******************
    public ItemDTO toItemDTO(ItemEntity item){
        return mapper.map(item,ItemDTO.class);
    }
    public ItemEntity toItemEntity(ItemDTO itemDTO){
        return mapper.map(itemDTO,ItemEntity.class);
    }
    public List<ItemDTO>toItemDTOList(List<ItemEntity>items){
        return mapper.map(items,List.class);
    }
}
