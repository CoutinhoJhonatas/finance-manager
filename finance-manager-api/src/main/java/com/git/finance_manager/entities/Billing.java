package com.git.finance_manager.entities;

import com.git.finance_manager.entities.enums.BillingStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDate dueDate;
    private LocalDate paidAt;
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private BillingStatus status;
    private String barcode;
    private String pix;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "billingId",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Attachment> attachments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "recurrence_id")
    private Recurrence recurrence;

}
