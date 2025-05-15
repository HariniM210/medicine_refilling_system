package com.MedRef.MedApp.model;

import javax.persistence.*;

@Entity
public class MedicineStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int stockCount;

    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;

    // Constructors
    public MedicineStock() {}

    public MedicineStock(int stockCount, Medicine medicine) {
        this.stockCount = stockCount;
        this.medicine = medicine;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}
