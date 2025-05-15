package com.MedRef.MedApp.service;

import com.MedRef.MedApp.model.Expense;
import com.MedRef.MedApp.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // Get all expenses
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Get expense by ID (Updated to use Long for ID)
    public Optional<Expense> getExpenseById(Long id) {  // ID updated to Long
        return expenseRepository.findById(id);
    }

    // Add a new expense
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // Update an expense (Updated to handle Long ID correctly)
    public Expense updateExpense(Long id, Expense updatedExpense) {  // ID added as Long
        Optional<Expense> existingExpense = expenseRepository.findById(id);
        if (existingExpense.isPresent()) {
            Expense expense = existingExpense.get();
            expense.setAmount(updatedExpense.getAmount());
            expense.setDate(updatedExpense.getDate());
            expense.setMedicine(updatedExpense.getMedicine());  // Assuming 'medicine' is the correct field
            return expenseRepository.save(expense);
        } else {
            throw new RuntimeException("Expense not found with id " + id); // You can create a custom exception if needed
        }
    }

    // Delete an expense by ID (Updated to handle Long ID correctly)
    public void deleteExpense(Long id) {  // ID updated to Long
        Optional<Expense> existingExpense = expenseRepository.findById(id);
        if (existingExpense.isPresent()) {
            expenseRepository.delete(existingExpense.get());
        } else {
            throw new RuntimeException("Expense not found with id " + id); // Custom exception handling
        }
    }
}
