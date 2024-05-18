package lk.ijse.gdse65.AAD_Course_Work.controller;

import lk.ijse.gdse65.AAD_Course_Work.dto.SaleDTO;
import lk.ijse.gdse65.AAD_Course_Work.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sale")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:63342")
public class Sale {
    private final SaleService saleService;

    @GetMapping("/health")
    public String healthTest(){
        return "Sales Ok";
    }

    @PostMapping
    public SaleDTO saveSale(@RequestBody SaleDTO sale) {
        return saleService.saveSale(sale);
    }
    @GetMapping
    public List<SaleDTO> getAllSale() {
        return saleService.getAllSales();
    }
}

