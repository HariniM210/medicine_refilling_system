package com.MedRef.MedApp.repository;

import com.MedRef.MedApp.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> { // Use Long instead of Integer

    // Find medicines that haven't been taken today
    List<Medicine> findByTakenTodayFalse();

    // Find medicines with low stock
    List<Medicine> findByStockCountLessThan(int threshold);  // Correct method for low stock
}
