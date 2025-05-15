package com.MedRef.MedApp.service;

import com.MedRef.MedApp.model.MedicineSchedule;
import com.MedRef.MedApp.repository.MedicineScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineScheduleService {

    @Autowired
    private MedicineScheduleRepository medicineScheduleRepository;

    // Get all medicine schedules
    public List<MedicineSchedule> getAllMedicineSchedules() {
        return medicineScheduleRepository.findAll();
    }

    // Get medicine schedule by ID
    public Optional<MedicineSchedule> getMedicineScheduleById(Long id) {
        return medicineScheduleRepository.findById(id);
    }

    // Add a new medicine schedule
    public MedicineSchedule addMedicineSchedule(MedicineSchedule medicineSchedule) {
        return medicineScheduleRepository.save(medicineSchedule);
    }

    // Update a medicine schedule
    public MedicineSchedule updateMedicineSchedule(Long id, MedicineSchedule medicineSchedule) {
        // First check if the schedule exists
        if (medicineScheduleRepository.existsById(id)) {
            medicineSchedule.setId(id); // Ensure the ID matches the request
            return medicineScheduleRepository.save(medicineSchedule);
        } else {
            throw new RuntimeException("Medicine Schedule not found with ID: " + id);
        }
    }

    // Delete a medicine schedule by ID
    public void deleteMedicineSchedule(Long id) {
        if (medicineScheduleRepository.existsById(id)) {
            medicineScheduleRepository.deleteById(id);
        } else {
            throw new RuntimeException("Medicine Schedule not found with ID: " + id);
        }
    }

    // Mark medicine as taken
    public MedicineSchedule markAsTaken(Long id) {
        Optional<MedicineSchedule> scheduleOptional = medicineScheduleRepository.findById(id);
        if (scheduleOptional.isPresent()) {
            MedicineSchedule schedule = scheduleOptional.get();
            schedule.setTakenToday(true);  // Use setTakenToday instead of setTaken
            return medicineScheduleRepository.save(schedule);
        } else {
            throw new RuntimeException("Medicine Schedule not found with ID: " + id);
        }
    }
}
