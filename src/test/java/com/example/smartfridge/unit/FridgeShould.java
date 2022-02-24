package com.example.smartfridge.unit;

import com.example.smartfridge.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
public class FridgeShould {
    @Mock
    Clock clock;
    private Fridge fridge;
    @Mock
    ItemsService itemsService;

    @BeforeEach void
    set_up(){
        fridge = new Fridge(clock, itemsService);
    }

    @Test void
    set_the_given_date_as_current(){
        //Given
        String currentDate = "18/10/2021";

        //When
        fridge.setCurrentDate(currentDate);

        //Then
        verify(clock).setDate(currentDate);
    };

    @Test void
    update_items_expiry_date_when_door_is_opened(){

        //When
        fridge.signalFridgeDoorOpened();

        //Then
        verify(itemsService).updateExpiry();
    }

    @Test void
    scan_and_record_added_items(){
        //Given
        String name = "itemName";
        String expiry = "12/12/2020";
        String condition = "sealed";

        //When
        fridge.scanAddedItem(name, expiry, condition);

        //Then
        verify(itemsService).record(name, expiry, condition);
    }


}
