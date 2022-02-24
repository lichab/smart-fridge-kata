package com.example.smartfridge.unit;

import com.example.smartfridge.Fridge;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class FridgeShould {
    @Mock Clock clock;

    @Test void
    set_the_current_date(){
        //Given
        Fridge fridge = new Fridge(clock);
        String currentDate = "18/10/2021";

        //When
        fridge.setCurrentDate(currentDate);

        //Then
        verify(clock).setDate(currentDate);
    };

}
