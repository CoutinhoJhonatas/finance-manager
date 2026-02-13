package com.git.finance_manager.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BillingResponse {

    private Long id;
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate paidAt;
    private BigDecimal amount;
    private String status;
    private String barcode;
    private String pix;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;
    private List<AttachmentResponse> attachments;
}
