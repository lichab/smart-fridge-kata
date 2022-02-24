package com.example.smartfridge;

import static org.yaml.snakeyaml.util.EnumUtils.findEnumInsensitiveCase;


public class Fridge {
    private final Clock clock;
    private final ItemsService itemsService;

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
        Condition itemCondition =  findEnumInsensitiveCase(Condition.class, condition);

        itemsService.record(item, expiry, itemCondition);
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
