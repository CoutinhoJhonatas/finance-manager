package com.git.finance_manager.services;

import com.git.finance_manager.dtos.request.BillingRequest;
import com.git.finance_manager.dtos.response.BillingResponse;
import com.git.finance_manager.entities.Billing;
import com.git.finance_manager.entities.enums.BillingStatus;
import com.git.finance_manager.repositories.BillingRepository;
import com.git.finance_manager.repositories.RecurrenceRepository;
import com.git.finance_manager.repositories.specifications.BillingSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BillingService {

    private final BillingRepository billingRepository;
    private final RecurrenceRepository recurrenceRepository;

    @Transactional
    public BillingResponse create(BillingRequest billingRequest) {
        Billing billing = new Billing();
        billing.setDescription(billingRequest.getDescription());
        billing.setDueDate(billingRequest.getDueDate());
        billing.setPaidAt(billingRequest.getPaidAt());
        billing.setAmount(BigDecimal.valueOf(billingRequest.getAmount()));
        billing.setStatus(BillingStatus.fromValue(billingRequest.getStatus()));
        billing.setBarcode(billingRequest.getBarcode());
        billing.setPix(billingRequest.getPix());

        LocalDateTime now = LocalDateTime.now();
        billing.setCreatedAt(now);
        billing.setUpdatedAt(now);

        billing = billingRepository.save(billing);

        //logica para salvar os anexos
        //logica para salvar a recorrencia

        return createBillingResponse(billing);
    }

    public List<BillingResponse> findBillings(LocalDate startDate, LocalDate endDate, String status) {
        Specification<Billing> spec = BillingSpecification.dueDateBetween(startDate, endDate);

        if (status != null) {
            spec = spec.and(BillingSpecification.hasStatus(status));
        }

        return billingRepository.findAll(spec)
                .stream()
                .map(this::createBillingResponse)
                .toList();
    }

    private BillingResponse createBillingResponse(Billing billing) {
        return BillingResponse.builder()
                .id(billing.getId())
                .description(billing.getDescription())
                .dueDate(billing.getDueDate())
                .paidAt(billing.getPaidAt())
                .amount(billing.getAmount())
                .status(billing.getStatus().name())
                .barcode(billing.getBarcode())
                .pix(billing.getPix())
                .createdAt(billing.getCreatedAt())
                .updatedAt(billing.getUpdatedAt())
                // Lógica para mapear os anexos
                .build();
    }
}
