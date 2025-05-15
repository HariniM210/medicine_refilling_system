package com.MedRef.MedApp.controller;

import com.MedRef.MedApp.model.MedicineStock;
import com.MedRef.MedApp.service.MedicineStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class MedicineStockController {

    @Autowired
    private MedicineStockService medicineStockService;

    @GetMapping
    public List<MedicineStock> getAllStockItems() {
        return medicineStockService.getAllStockItems();
    }

    @PostMapping
    public MedicineStock addStockItem(@RequestBody MedicineStock stock) {
        return medicineStockService.addStockItem(stock);
    }

    @PutMapping("/{id}")
    public MedicineStock updateStock(@PathVariable Long id, @RequestBody MedicineStock updatedStock) {
        return medicineStockService.updateStock(id, updatedStock);
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable Long id) {
        medicineStockService.deleteStock(id);
    }
}
