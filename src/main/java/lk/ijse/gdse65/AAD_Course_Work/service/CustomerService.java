package lk.ijse.gdse65.AAD_Course_Work.service;

import lk.ijse.gdse65.AAD_Course_Work.Exception.NotFoundException;
import lk.ijse.gdse65.AAD_Course_Work.dto.CustomerDTO;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customer);
    CustomerDTO getSelectedCustomer(String id);
    boolean deleteCustomer(String id) throws NotFoundException;
    boolean updateCustomer(String id,CustomerDTO Customer)throws NotFoundException;
    List<CustomerDTO> getAllCustomers();


}
