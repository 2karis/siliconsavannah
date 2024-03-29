package io.siliconsavannah.backend.controller;

import io.siliconsavannah.backend.dto.ExpenseDto;
import io.siliconsavannah.backend.model.Expense;
import io.siliconsavannah.backend.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ={"http://localhost:4200", "http://localhost:80"})
@RequestMapping("/expense")
public class ExpenseController {
    @Autowired
    public ExpenseService expenseService;

    @GetMapping("/readall")
    public ResponseEntity<List<ExpenseDto>> getAllExpenses(){
        return new ResponseEntity<>(expenseService.readAllExpenses(), HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<ExpenseDto> getExpense(@PathVariable("id") int id){
        return new ResponseEntity<>(expenseService.findExpenseById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense){
        return new ResponseEntity<>(expenseService.createExpense(expense), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ExpenseDto>updateExpense(@RequestBody ExpenseDto expense){
        return new ResponseEntity<>(expenseService.updateExpense(expense), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable("id") int id){
        expenseService.deleteExpense(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
