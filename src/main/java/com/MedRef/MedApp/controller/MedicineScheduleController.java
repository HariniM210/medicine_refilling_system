package com.MedRef.MedApp.controller;

import com.MedRef.MedApp.model.MedicineSchedule;
import com.MedRef.MedApp.service.MedicineScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class MedicineScheduleController {

    @Autowired
    private MedicineScheduleService medicineScheduleService;

    @GetMapping
    public List<MedicineSchedule> getAllSchedules() {
        return medicineScheduleService.getAllMedicineSchedules();  // Changed method name here
    }

    @PostMapping
    public MedicineSchedule addSchedule(@RequestBody MedicineSchedule schedule) {
        return medicineScheduleService.addMedicineSchedule(schedule);  // Changed method name here
    }

    @PutMapping("/{id}/taken")
    public void markAsTaken(@PathVariable Long id) {
        medicineScheduleService.markAsTaken(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id) {
        medicineScheduleService.deleteMedicineSchedule(id);  // Changed method name here
    }
}
