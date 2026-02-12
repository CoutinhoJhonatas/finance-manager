package com.git.finance_manager.services;

import com.git.finance_manager.dtos.request.BillingRequest;
import com.git.finance_manager.dtos.response.BillingResponse;
import com.git.finance_manager.entities.Billing;
import com.git.finance_manager.entities.enums.BillingStatus;
import com.git.finance_manager.repositories.BillingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BillingService {

    private final BillingRepository billingRepository;

    @Transactional
    public BillingResponse create(BillingRequest billingRequest) {
        Billing billing = new Billing();
        billing.setDescription(billingRequest.getDescription());
        billing.setDueDate(LocalDate.parse(billingRequest.getDueDate()));
        billing.setPaidAt(billingRequest.getPaidAt() != null ? LocalDate.parse(billingRequest.getPaidAt()) : null);
        billing.setAmount(BigDecimal.valueOf(billingRequest.getAmount()));
        billing.setStatus(BillingStatus.fromValue(billingRequest.getStatus()));
        billing.setBarcode(billingRequest.getBarcode() != null ? billingRequest.getBarcode() : null);
        billing.setPix(billingRequest.getPix() != null ? billingRequest.getPix() : null);
        billing.setCreatedAt(LocalDateTime.now());
        billing.setUpdatedAt(LocalDateTime.now());

        billing = billingRepository.save(billing);

        //logica para salvar os anexos

        if (billingRequest.getRecurrenceQuantity() != null) {
            // Lógica para lidar com a recorrência
        }

        return createBillingResponse(billing);
    }

    private BillingResponse createBillingResponse(Billing billing) {
        return BillingResponse.builder()
                .id(billing.getId())
                .description(billing.getDescription())
                .dueDate(billing.getDueDate().toString())
                .paidAt(billing.getPaidAt() != null ? billing.getPaidAt().toString() : null)
                .amount(billing.getAmount())
                .status(billing.getStatus().name())
                .barcode(billing.getBarcode())
                .pix(billing.getPix())
                .createdAt(billing.getCreatedAt().toString())
                .updatedAt(billing.getUpdatedAt().toString())
                // Lógica para mapear os anexos
                .build();
    }
}
