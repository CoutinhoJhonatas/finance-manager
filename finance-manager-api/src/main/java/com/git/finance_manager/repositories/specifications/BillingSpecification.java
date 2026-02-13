package com.git.finance_manager.repositories.specifications;

import com.git.finance_manager.entities.Billing;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class BillingSpecification {

    private BillingSpecification() {
    }


    public static Specification<Billing> dueDateBetween(LocalDate startDate, LocalDate endDate) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.between(root.get("dueDate"), startDate, endDate);
    }

    public static Specification<Billing> hasStatus(String status) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("status"), status);
    }
}
