package lk.ijse.gdse65.AAD_Course_Work.service;

import lk.ijse.gdse65.AAD_Course_Work.dto.SaleDTO;

import java.util.List;

public interface SaleService {
    SaleDTO saveSale(SaleDTO sale);
    List<SaleDTO> getAllSales();
}
