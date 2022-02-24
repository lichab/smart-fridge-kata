package com.example.smartfridge;

public enum Condition {
    SEALED("sealed"),
    OPEN("open");

    private final String value;

    Condition(String value) {
        this.value = value;
    }
}
