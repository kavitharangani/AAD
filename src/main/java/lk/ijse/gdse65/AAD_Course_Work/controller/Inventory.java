package lk.ijse.gdse65.AAD_Course_Work.controller;

import jakarta.validation.Valid;
import lk.ijse.gdse65.AAD_Course_Work.dto.InventoryDTO;
import lk.ijse.gdse65.AAD_Course_Work.service.InventoryService;
import lk.ijse.gdse65.AAD_Course_Work.util.UtilMatters;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:63342")

public class Inventory {
    private final InventoryService inventoryService;

    @GetMapping("/count")
    public ResponseEntity<Long> countInventory() {
        long totalInventory = inventoryService.count();
        return ResponseEntity.ok(totalInventory);
    }

    @GetMapping("/health")
    public String healthTest(){
        return "Inventory Ok";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public InventoryDTO save(
            @Valid @RequestPart("item_code") String item_code,
            @RequestPart("item_desc") String item_desc,
            @RequestPart("item_qty") String item_qty,
            @RequestPart("item_pic") String item_pic,
            @RequestPart("category") String category,
            @RequestPart("size") String size,
            @RequestPart("unit_price_sale") String unit_price_sale,
            @RequestPart("unit_price_buy") String unit_price_buy,
            @RequestPart("expected_profit") String expected_profit,
            @RequestPart("profit_margin") String profit_margin,
            @RequestPart("status") String status,
            Errors errors
    ) {
        if (errors.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    errors.getFieldErrors().get(0).getDefaultMessage());
        }

        String base64ProPic = UtilMatters.convertBase64(item_pic);

        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setItem_code(item_code);
        inventoryDTO.setItem_desc(item_desc);
        inventoryDTO.setItem_pic(base64ProPic);
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

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public InventoryDTO updateInventory(
            @Valid @RequestPart("item_code") String item_code,
            @RequestPart("item_desc") String item_desc,
            @RequestPart("item_qty") String item_qty,
            @RequestPart("item_pic") String item_pic,
            @RequestPart("category") String category,
            @RequestPart("size") String size,
            @RequestPart("unit_price_sale") String unit_price_sale,
            @RequestPart("unit_price_buy") String unit_price_buy,
            @RequestPart("expected_profit") String expected_profit,
            @RequestPart("profit_margin") String profit_margin,
            @RequestPart("status") String status,
            Errors errors) {

        if (errors.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    errors.getFieldErrors().get(0).getDefaultMessage());
        }

        String base64ProPic = UtilMatters.convertBase64(item_pic);

        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setItem_code(item_code);
        inventoryDTO.setItem_desc(item_desc);
        inventoryDTO.setItem_pic(base64ProPic);
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

    @GetMapping
    public List<InventoryDTO> getAllInventory() {
        return inventoryService.getAllInventory();
    }

}
