package com.git.finance_manager.controllers;

import com.git.finance_manager.dtos.request.BillingRequest;
import com.git.finance_manager.dtos.response.BillingResponse;
import com.git.finance_manager.services.BillingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("billings")
@RequiredArgsConstructor
public class BillingController {

    private final BillingService billingService;

    @PostMapping
    public BillingResponse create(@RequestBody BillingRequest request) {
        return billingService.create(request);
    }
}
