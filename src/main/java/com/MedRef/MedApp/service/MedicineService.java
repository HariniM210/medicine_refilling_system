package com.MedRef.MedApp.service;

import com.MedRef.MedApp.exception.ResourceNotFoundException;
import com.MedRef.MedApp.model.Medicine;
import com.MedRef.MedApp.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    // Get all medicines
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    // Get medicine by ID (Updated to use Long instead of Integer)
    public Optional<Medicine> getMedicineById(Long id) {  // Updated to Long
        return medicineRepository.findById(id);
    }

    // Add a new medicine
    public Medicine addMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    // Update a medicine (Handle the ID correctly and use the correct getter/setter)
    public Medicine updateMedicine(Long id, Medicine updatedMedicine) {
        Optional<Medicine> existingMedicine = medicineRepository.findById(id);
        if (existingMedicine.isPresent()) {
            Medicine medicine = existingMedicine.get();
            medicine.setName(updatedMedicine.getName());
            medicine.setStock(updatedMedicine.getStock());
            medicine.setPricePerUnit(updatedMedicine.getPricePerUnit());  // Assuming 'PricePerUnit' is the correct field
            // Update other fields as necessary
            return medicineRepository.save(medicine);
        } else {
            throw new ResourceNotFoundException("Medicine not found with id " + id);
        }
    }

    // Delete a medicine by ID (Updated to accept Long for ID)
    public void deleteMedicine(Long id) {
        Optional<Medicine> existingMedicine = medicineRepository.findById(id);
        if (existingMedicine.isPresent()) {
            medicineRepository.delete(existingMedicine.get());
        } else {
            throw new ResourceNotFoundException("Medicine not found with id " + id);
        }
    }

    // Get medicines with low stock (Updated method name to reflect correct logic)
    public List<Medicine> getLowStockMedicines() {
        return medicineRepository.findByStockCountLessThan(10); // Assuming low stock threshold is 10
    }
}
