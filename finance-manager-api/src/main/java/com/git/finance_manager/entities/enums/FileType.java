package com.git.finance_manager.entities.enums;

public enum FileType {
    PDF,
    PNG,
    JPG;

    public static FileType fromValue(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }

        return switch (value.toUpperCase()) {
            case "PDF" -> PDF;
            case "PNG" -> PNG;
            case "JPG" -> JPG;
            default -> throw new IllegalArgumentException("Invalid type: " + value);
        };
    }
}
