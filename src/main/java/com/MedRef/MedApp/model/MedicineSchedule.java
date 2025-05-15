package com.MedRef.MedApp.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class MedicineSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private boolean takenToday;

    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;

    // Constructors
    public MedicineSchedule() {}

    public MedicineSchedule(LocalDate startDate, LocalDate endDate, boolean takenToday, Medicine medicine) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.takenToday = takenToday;
        this.medicine = medicine;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isTakenToday() {
        return takenToday;
    }

    public void setTakenToday(boolean takenToday) {
        this.takenToday = takenToday;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    // New method to mark as taken
    public void markAsTaken() {
        this.takenToday = true;  // Mark the medicine as taken for today
    }

    // Optional method to mark as not taken (if needed)
    public void markAsNotTaken() {
        this.takenToday = false;  // Mark the medicine as not taken for today
    }
}
