package com.git.finance_manager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Recurrence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer quantityInMonths;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "recurrence")
    private List<Billing> billings = new ArrayList<>();

    public Recurrence (String description, Integer quantityInMonths) {
        this.description = description;
        this.quantityInMonths = quantityInMonths;
        this.createdAt = LocalDateTime.now();
    }
}
