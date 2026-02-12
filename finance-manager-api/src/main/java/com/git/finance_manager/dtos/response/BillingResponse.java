package com.git.finance_manager.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BillingResponse {

    private Long id;
    private String description;
    private String dueDate;
    private String paidAt;
    private BigDecimal amount;
    private String status;
    private String barcode;
    private String pix;
    private String createdAt;
    private String updatedAt;
    private List<AttachmentResponse> attachments;
}
