package com.MedRef.MedApp.repository;

import com.MedRef.MedApp.model.MedicineSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate; 
import java.util.List;
import java.util.Optional;

@Repository
public interface MedicineScheduleRepository extends JpaRepository<MedicineSchedule, Long> {

    // Custom query to find all MedicineSchedules by medicine ID
    List<MedicineSchedule> findByMedicineId(Long medicineId);

    // Optional: Custom query to find a MedicineSchedule by its ID
    Optional<MedicineSchedule> findById(Long id);

    // Optional: Custom query to find schedules by takenToday status
    List<MedicineSchedule> findByTakenToday(boolean takenToday);

    // Optional: Custom query to find schedules within a date range
    List<MedicineSchedule> findByStartDateBetween(LocalDate startDate, LocalDate endDate);
}
