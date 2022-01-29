package com.expense.expenseitem.Model;

import javax.validation.constraints.NotBlank;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
public class Bill {
    private final String id;
    @NotBlank(message = "Amount is required")
    private int amount;
    @NotBlank(message = "Description is required")
    private String description;
    @NotBlank(message = "Select Date")
    private String day;
    @NotBlank(message = "Select Date")
    private String month;
    @NotBlank(message = "Select Year")
    private String year;
}
