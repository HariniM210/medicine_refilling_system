package com.MedRef.MedApp.repository;

import com.MedRef.MedApp.model.MedicineStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineStockRepository extends JpaRepository<MedicineStock, Long> {  // Change Integer to Long

    // Find low-stock medicines
    List<MedicineStock> findByCurrentStockLessThan(int threshold);

    // Find stock by medicine ID
    MedicineStock findByMedicineId(int medicineId);
}
