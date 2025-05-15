package com.MedRef.MedApp.service;

import com.MedRef.MedApp.model.MedicineStock;
import com.MedRef.MedApp.repository.MedicineStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineStockService {

    @Autowired
    private MedicineStockRepository medicineStockRepository;

    // Get all medicine stocks
    public List<MedicineStock> getAllStockItems() {  
        return medicineStockRepository.findAll();
    }

    // Get medicine stock by ID
    public Optional<MedicineStock> getMedicineStockById(Long id) {  // Using Long now
        return medicineStockRepository.findById(id);
    }

    // Add a new medicine stock
    public MedicineStock addStockItem(MedicineStock medicineStock) {  
        return medicineStockRepository.save(medicineStock);
    }

    // Update a medicine stock
    public MedicineStock updateStock(Long id, MedicineStock updatedStock) {  // Using Long now
        Optional<MedicineStock> existingStock = medicineStockRepository.findById(id);
        if (existingStock.isPresent()) {
            MedicineStock stock = existingStock.get();
            stock.setMedicine(updatedStock.getMedicine());
            stock.setStockCount(updatedStock.getStockCount());  // Using stockCount instead of quantity
            return medicineStockRepository.save(stock);
        } else {
            throw new RuntimeException("Stock not found with id " + id);  
        }
    }

    // Delete a medicine stock by ID
    public void deleteStock(Long id) {  // Using Long now
        Optional<MedicineStock> existingStock = medicineStockRepository.findById(id);
        if (existingStock.isPresent()) {
            medicineStockRepository.delete(existingStock.get());
        } else {
            throw new RuntimeException("Stock not found with id " + id);  
        }
    }
}
