package lk.ijse.gdse65.AAD_Course_Work.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse65.AAD_Course_Work.dto.SaleDTO;
import lk.ijse.gdse65.AAD_Course_Work.repo.SaleDAO;
import lk.ijse.gdse65.AAD_Course_Work.service.SaleService;
import lk.ijse.gdse65.AAD_Course_Work.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class  SaleIMPL implements SaleService {

    private final SaleDAO saleDAO;
    private final Mapping mapping;

    @Override
    public SaleDTO saveSale(SaleDTO sale) {
        sale.setOrder_no(UUID.randomUUID().toString());
        return mapping.toSaleDTO(saleDAO.save(mapping.toSaleEntity(sale)));
    }

    @Override
    public List<SaleDTO> getAllSales() {
        return mapping.toSaleDTOList(saleDAO.findAll());
    }
}
