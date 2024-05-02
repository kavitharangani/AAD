package lk.ijse.gdse65.AAD_Course_Work.controller;

import lk.ijse.gdse65.AAD_Course_Work.dto.CustomerDTO;
import lk.ijse.gdse65.AAD_Course_Work.dto.InventoryDTO;
import lk.ijse.gdse65.AAD_Course_Work.dto.SupplierDTO;
import lk.ijse.gdse65.AAD_Course_Work.service.InventoryService;
import lk.ijse.gdse65.AAD_Course_Work.util.UtilMatters;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class Inventory {
    private final InventoryService inventoryService;

    @GetMapping("/health")
    public String healthTest(){
        return "Inventory Ok";
    }

    @PostMapping
    public InventoryDTO save(
                @RequestPart("item_desc") String item_desc,
                @RequestPart("item_qty") String item_qty,
                @RequestPart("item_pic") String item_pic,
                @RequestPart("category") String category,
                @RequestPart("size") String size,
                @RequestPart("unit_price_sale") String unit_price_sale,
                @RequestPart("unit_price_buy") String unit_price_buy,
                @RequestPart("expected_profit") String expected_profit,
                @RequestPart("profit_margin") String profit_margin,
                @RequestPart("status") String status
    ){

            InventoryDTO inventoryDTO = new InventoryDTO();
            inventoryDTO.setItem_code(UUID.randomUUID().toString());
            inventoryDTO.setItem_desc(item_desc);
            inventoryDTO.setItem_pic(UtilMatters.convertBase64(item_pic));
            inventoryDTO.setCategory(category);
            inventoryDTO.setItem_qty(Integer.parseInt(item_qty));
            inventoryDTO.setSize(Integer.parseInt(size));
            inventoryDTO.setUnit_price_sale(Double.parseDouble(unit_price_sale));
            inventoryDTO.setUnit_price_buy(Double.parseDouble(unit_price_buy));
            inventoryDTO.setExpected_profit(Double.parseDouble(expected_profit));
            inventoryDTO.setProfit_margin(Double.parseDouble(profit_margin));
            inventoryDTO.setStatus(status);

            return inventoryService.saveInventory(inventoryDTO);
    }

    @PatchMapping
    public void updateInventory(
            @RequestPart("item_code") String item_code,
            @RequestPart("item_desc") String item_desc,
            @RequestPart("item_qty") String item_qty,
            @RequestPart("item_pic") String item_pic,
            @RequestPart("category") String category,
            @RequestPart("size") String size,
            @RequestPart("unit_price_sale") String unit_price_sale,
            @RequestPart("unit_price_buy") String unit_price_buy,
            @RequestPart("expected_profit") String expected_profit,
            @RequestPart("profit_margin") String profit_margin,
            @RequestPart("status") String status
    ){
        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setItem_code(item_code);
        inventoryDTO.setItem_code(UUID.randomUUID().toString());
        inventoryDTO.setItem_desc(item_desc);
        inventoryDTO.setItem_pic(UtilMatters.convertBase64(item_pic));
        inventoryDTO.setCategory(category);
        inventoryDTO.setItem_qty(Integer.parseInt(item_qty));
        inventoryDTO.setSize(Integer.parseInt(size));
        inventoryDTO.setUnit_price_sale(Double.parseDouble(unit_price_sale));
        inventoryDTO.setUnit_price_buy(Double.parseDouble(unit_price_buy));
        inventoryDTO.setExpected_profit(Double.parseDouble(expected_profit));
        inventoryDTO.setProfit_margin(Double.parseDouble(profit_margin));
        inventoryDTO.setStatus(status);

        inventoryService.updateInventory(item_code, inventoryDTO);
    }

    @DeleteMapping(value = "/{item_code}")
    public void deleteInventory(String item_code)  {
        inventoryService.deleteInventory(item_code);
    }

    @GetMapping
    public List<InventoryDTO> getAllInventory() {
        return inventoryService.getAllInventory();
    }

}
