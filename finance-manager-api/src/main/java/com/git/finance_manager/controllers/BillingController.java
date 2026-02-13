package com.git.finance_manager.controllers;

import com.git.finance_manager.dtos.request.BillingRequest;
import com.git.finance_manager.dtos.response.BillingResponse;
import com.git.finance_manager.services.BillingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("billings")
@RequiredArgsConstructor
public class BillingController {

    private final BillingService billingService;

    @PostMapping
    public ResponseEntity<BillingResponse> create(@Valid @RequestBody BillingRequest request) {
        return new ResponseEntity<>(billingService.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BillingResponse>> getBillings(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate,
            @RequestParam(required = false) String status
            ) {
        return ResponseEntity.ok(billingService.findBillings(startDate, endDate, status));
    }
}
