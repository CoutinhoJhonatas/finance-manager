package com.git.finance_manager.entities.enums;

public enum BillingStatus {
    EXPECTED,
    PAID;

    public static BillingStatus fromValue(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }

        return switch (value.toUpperCase()) {
            case "EXPECTED" -> EXPECTED;
            case "PAID" -> PAID;
            default -> throw new IllegalArgumentException("Invalid status: " + value);
        };
    }
}
