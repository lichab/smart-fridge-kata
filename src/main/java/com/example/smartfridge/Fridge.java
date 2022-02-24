package com.example.smartfridge;

import com.example.smartfridge.unit.Clock;

public class Fridge {
    private Clock clock;

    public Fridge(Clock clock) {
        this.clock = clock;
    }

    public String showDisplay() {
        throw new UnsupportedOperationException();
    }

    public void signalFridgeDoorOpened() {
        throw new UnsupportedOperationException();
    }

    public void scanAddedItem(String item, String expiry, String condition) {
        throw new UnsupportedOperationException();
    }

    public void signalFridgeDoorClosed() {
        throw new UnsupportedOperationException();
    }

    public void simulateDayOver() {
        throw new UnsupportedOperationException();
    }

    public void scanRemovedItem(String item) {
        throw new UnsupportedOperationException();
    }

    public void setCurrentDate(String date) {
        clock.setDate(date);
    }
}
