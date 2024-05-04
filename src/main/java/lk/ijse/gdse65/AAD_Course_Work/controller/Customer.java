package lk.ijse.gdse65.AAD_Course_Work.controller;

import lk.ijse.gdse65.AAD_Course_Work.Exception.NotFoundException;
import lk.ijse.gdse65.AAD_Course_Work.dto.CustomerDTO;
import lk.ijse.gdse65.AAD_Course_Work.dto.EmployeeDTO;
import lk.ijse.gdse65.AAD_Course_Work.dto.SupplierDTO;
import lk.ijse.gdse65.AAD_Course_Work.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:63342")
public class Customer {

    private final CustomerService customerService;

    @GetMapping("/health")
    public String healthTest(){
        return "Customer Health Test AAD course work";
    }

    @PostMapping
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @DeleteMapping(value = "/{customer_code}")
    public boolean deleteCustomer(@PathVariable ("customer_code") String id) throws NotFoundException {
        return customerService.deleteCustomer(id);
    }

    @PatchMapping
    public boolean update(@RequestBody CustomerDTO customerDTO) throws  NotFoundException {
        return customerService.updateCustomer(customerDTO.getCustomer_code(),customerDTO);
    }

}
