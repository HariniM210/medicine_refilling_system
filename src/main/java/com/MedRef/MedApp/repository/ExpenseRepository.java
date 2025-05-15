package com.MedRef.MedApp.repository;

import com.MedRef.MedApp.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {  // Change Integer to Long

    // Find expenses by date
    List<Expense> findByDate(LocalDate date);

    // Get all expenses within a date range
    List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
