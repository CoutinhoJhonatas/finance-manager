package com.git.finance_manager.dtos.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BillingRequest {

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Due date is required")
    @FutureOrPresent(message = "Due date must be today or in the future")
    private LocalDate dueDate;

    @FutureOrPresent(message = "Due date must be today or in the future")
    private LocalDate paidAt;

    @NotNull(message = "Amount is required")
    @DecimalMin(value ="0.01", message = "Amount must be greater than zero")
    private Double amount;

    @NotBlank(message = "Status is required")
    private String status;
    private String barcode;
    private String pix;

    @Positive(message = "Recurrence months quantity must be greater than zero")
    private Integer recurrenceMonthsQuantity;
}
