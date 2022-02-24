package com.example.smartfridge;

import java.util.List;

public class Fridge {
    private Clock clock;
    private ItemsService itemsService;

    public Fridge(Clock clock, ItemsService itemsService) {
        this.clock = clock;
        this.itemsService = itemsService;
    }

    public String showDisplay() {
        throw new UnsupportedOperationException();
    }

    public void signalFridgeDoorOpened() {
        itemsService.updateExpiry();
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
