package com.git.finance_manager.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillingRequest {

    private String description;
    private String dueDate;
    private String paidAt;
    private Double amount;
    private String status;
    private String barcode;
    private String pix;
    private Integer recurrenceQuantity;
}
