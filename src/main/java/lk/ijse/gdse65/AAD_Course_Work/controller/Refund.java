package lk.ijse.gdse65.AAD_Course_Work.controller;

import lk.ijse.gdse65.AAD_Course_Work.Exception.NotFoundException;
import lk.ijse.gdse65.AAD_Course_Work.dto.CustomerDTO;
import lk.ijse.gdse65.AAD_Course_Work.dto.RefundDTO;
import lk.ijse.gdse65.AAD_Course_Work.service.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/refund")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:63342")
public class Refund {
    private final RefundService refundService;

    @GetMapping("/health")
    public String healthTest(){
        return "Refund Health Test AAD course work";
    }

    @PostMapping
    public RefundDTO saveRefund(@RequestBody RefundDTO refund) {
        return refundService.saveRefund(refund);
    }

    @GetMapping
    public List<RefundDTO> getAllRefunds() {
        return refundService.getAllRefund();
    }

    @DeleteMapping(value = "/{refundId}")
    public boolean deleteCustomer(@PathVariable ("refundId") String id) throws NotFoundException {
        return refundService.deleteRefund(id);
    }

    @PatchMapping(value = "/{refundId}")
    public boolean update(@RequestBody RefundDTO refundDTO) throws  NotFoundException {
        return refundService.updateRefund(refundDTO.getRefundId(),refundDTO);
    }

}
