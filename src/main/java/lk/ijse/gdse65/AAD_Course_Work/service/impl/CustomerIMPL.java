package lk.ijse.gdse65.AAD_Course_Work.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse65.AAD_Course_Work.Exception.NotFoundException;
import lk.ijse.gdse65.AAD_Course_Work.controller.Customer;
import lk.ijse.gdse65.AAD_Course_Work.dto.CustomerDTO;
import lk.ijse.gdse65.AAD_Course_Work.entity.CustomerEntity;
import lk.ijse.gdse65.AAD_Course_Work.repo.CustomerDAO;
import lk.ijse.gdse65.AAD_Course_Work.service.CustomerService;
import lk.ijse.gdse65.AAD_Course_Work.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerIMPL implements CustomerService {

    private final CustomerDAO customerDAO;
    private final Mapping mapping;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customer) {
        customer.setCustomer_code(UUID.randomUUID().toString());
        return mapping.toCustomerDTO(customerDAO.save(mapping.toCustomer(customer)));
    }

    @Override
    public CustomerDTO getSelectedCustomer(String id) {
        return null;
    }

    @Override
    public boolean deleteCustomer(String id) throws NotFoundException {
        Optional<CustomerEntity> customer = customerDAO.findById(id);
        if (customer.isPresent()) {
            customerDAO.deleteById(id);
            return true;
        }else{
            throw new NotFoundException(id+" not found (:");
        }
    }

    @Override
    public boolean updateCustomer(String id, CustomerDTO customerDTO) throws NotFoundException {
        Optional<CustomerEntity> tmpCustomerOptional = customerDAO.findById(id);
        if (tmpCustomerOptional.isPresent()) {
            CustomerEntity customer = tmpCustomerOptional.get();
            customer.setCustomer_name(customerDTO.getCustomer_name());
            customer.setGender(customerDTO.getGender());
            customer.setJoin_date(customerDTO.getJoin_date());
            customer.setLevel(customerDTO.getLevel());
            customer.setTotal_points(customerDTO.getTotal_points());
            customer.setDob(customerDTO.getDob());
            customer.setAddress1(customerDTO.getAddress1());
            customer.setAddress2(customerDTO.getAddress2());
            customer.setAddress3(customerDTO.getAddress3());
            customer.setAddress4(customerDTO.getAddress4());
            customer.setAddress5(customerDTO.getAddress5());
            customerDAO.save(customer);
            return true;
        } else {
            throw new NotFoundException(id + " not found :(");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapping.toCustomerDTOList(customerDAO.findAll());
    }
}
