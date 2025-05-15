package com.MedRef.MedApp.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String dosage;
    private double pricePerUnit;

    @OneToMany(mappedBy = "medicine")
    private List<MedicineSchedule> schedules;

    @OneToMany(mappedBy = "medicine")
    private List<MedicineStock> stock;

    @OneToMany(mappedBy = "medicine")
    private List<Expense> expenses;

    // Constructors
    public Medicine() {}

    public Medicine(String name, String dosage, double pricePerUnit) {
        this.name = name;
        this.dosage = dosage;
        this.pricePerUnit = pricePerUnit;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public List<MedicineSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<MedicineSchedule> schedules) {
        this.schedules = schedules;
    }

    public List<MedicineStock> getStock() {
        return stock;
    }

    public void setStock(List<MedicineStock> stock) {
        this.stock = stock;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
