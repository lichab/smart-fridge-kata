package com.example.smartfridge.acceptance;

import com.example.smartfridge.Fridge;
import com.example.smartfridge.unit.Clock;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FridgeTest {
	@Test
	void tracksAndDisplaysAddedItemsExpiry() {

		//Given
		String expectedOutput = "EXPIRED: Milk\n" +
				"Lettuce: 0 days remaining\n" +
				"Peppers: 1 day remaining\n" +
				"Cheese: 31 days remaining";
		Clock clock = new Clock();
		Fridge fridge = new Fridge(clock);
		fridge.setCurrentDate("18/10/2021");

		// When
		fridge.signalFridgeDoorOpened();
		fridge.scanAddedItem("Milk", "21/10/21", "sealed");
		fridge.scanAddedItem("Cheese", "18/11/21", "sealed");
		fridge.scanAddedItem("Beef", "20/10/21", "sealed");
		fridge.scanAddedItem("Lettuce", "22/10/21", "sealed");
		fridge.signalFridgeDoorClosed();

		fridge.simulateDayOver();

		fridge.signalFridgeDoorOpened();
		fridge.signalFridgeDoorClosed();

		fridge.signalFridgeDoorOpened();
		fridge.signalFridgeDoorClosed();

		fridge.signalFridgeDoorOpened();
		fridge.scanRemovedItem("Milk");
		fridge.signalFridgeDoorClosed();

		fridge.signalFridgeDoorOpened();
		fridge.scanAddedItem("Milk", "26/10/21", "opened");
		fridge.scanAddedItem("Peppers", "23/10/21", "opened");
		fridge.signalFridgeDoorClosed();

		fridge.simulateDayOver();

		fridge.signalFridgeDoorOpened();
		fridge.scanRemovedItem("Beef");
		fridge.scanRemovedItem("Lettuce");
		fridge.signalFridgeDoorClosed();

		fridge.signalFridgeDoorOpened();
		fridge.scanAddedItem("Lettuce", "22/10/21", "opened");
		fridge.signalFridgeDoorClosed();

		fridge.signalFridgeDoorOpened();
		fridge.signalFridgeDoorClosed();

		fridge.simulateDayOver();
		
		String actualOutput = fridge.showDisplay();

		// Then
		assertEquals(expectedOutput, actualOutput);
	}
}
