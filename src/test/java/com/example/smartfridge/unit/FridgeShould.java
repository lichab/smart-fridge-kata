package com.example.smartfridge.unit;

import com.example.smartfridge.Fridge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
public class FridgeShould {
    @Mock Clock clock;
    private Fridge fridge;

    @BeforeEach void
    set_up(){
        fridge = new Fridge(clock);
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
        //Given
        var item = mock(Item.class);
        List<Item> items = List.of(item, item, item);
        ItemRepository itemsRepository = mock(ItemRepository.class);
        when(itemsRepository.getAll()).thenReturn(items);

        //When
        fridge.signalFridgeDoorOpened();

        //Then
        verify(itemsRepository).getAll();
        verify(item, times(items.size())).updateExpiry();
    }


}
