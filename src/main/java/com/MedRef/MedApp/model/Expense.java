package com.MedRef.MedApp.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private double amount;

    // Many expenses can relate to one medicine
    @ManyToOne
    @JoinColumn(name = "medicine_id", nullable = false)  // Added nullable = false to ensure foreign key constraint
    private Medicine medicine;

    // Constructors
    public Expense() {}

    public Expense(LocalDate date, double amount, Medicine medicine) {
        this.date = date;
        this.amount = amount;
        this.medicine = medicine;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    // toString Method (optional, useful for debugging)
    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", medicine=" + (medicine != null ? medicine.getName() : "No Medicine") +  // Assuming `getName()` exists in Medicine
                '}';
    }
}
