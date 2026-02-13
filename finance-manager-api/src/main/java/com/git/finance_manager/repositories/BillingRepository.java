package com.git.finance_manager.repositories;

import com.git.finance_manager.entities.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository
        extends JpaRepository<Billing, Long>,
                JpaSpecificationExecutor<Billing> {
}
