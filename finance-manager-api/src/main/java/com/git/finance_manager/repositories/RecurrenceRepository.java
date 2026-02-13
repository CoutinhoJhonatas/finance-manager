package com.git.finance_manager.repositories;

import com.git.finance_manager.entities.Recurrence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecurrenceRepository extends JpaRepository<Recurrence, Long> {
}
