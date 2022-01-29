package com.expense.expenseitem.controller;

import java.util.ArrayList;
import java.util.List;

import com.expense.expenseitem.Model.Bill;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/home", produces = "application/json")
@CrossOrigin(origins = "*")
public class ExpenseController {
    private List<Bill> list = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Bill>> AllExpenseItem() {
        if (list.size() == 0) {
            System.out.println("No item has been added yet");
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        System.out.println(list);
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

    @GetMapping("/totalExpense")
    public ResponseEntity<Integer> ExpenseItemAmountTotal() {
        int amount = 0;
        for (Bill bill : list) {
            amount += bill.getAmount();
        }
        return new ResponseEntity<>(amount, HttpStatus.FOUND);
    }

    @GetMapping("/totalExpense/{month}")
    public ResponseEntity<Integer> ExpenseItemAmountMonthly(@PathVariable("month") String str) {
        int amount = 0;
        for (Bill bill : list) {
            if (bill.getMonth().equalsIgnoreCase(str)) {
                amount += bill.getAmount();
            }
        }
        return new ResponseEntity<>(amount, HttpStatus.FOUND);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Bill> addExpenseItem(@RequestBody Bill bill) {
        list.add(bill);
        System.out.println(bill);
        return new ResponseEntity<>(bill, HttpStatus.CREATED);
    }
}
