package parkinglot.datamanager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import parkinglot.datamanager.DataManager;

public class DataManagerTest {
	
	@Test
	void testCreateParkingLotTest()
    {
		int slotCount = 5;
		DataManager.createParkingLot(slotCount);
		assertEquals(slotCount, DataManager.getParkingLot().getSlots().size());
    }
	
//	@Test
//	void testParkVehicle()
//    {
//		String registrationNumber = "reg-1", color = "black";
//        DataManager.createParkingLot(1);
//        assertNotEquals(-1, DataManager.parkVehicle(registrationNumber, color));
//    }
//	
//	@Test
//	void testLeave() {
//		DataManager.createParkingLot(1);
//		String registrationNumber = "reg-1", color = "black";
//		if (DataManager.parkVehicle(registrationNumber, color) != -1)
//			assertNotEquals(-1, DataManager.leave(1));
//	}
	
//	@Test
//	void testGetStatus() {
//		DataManager.createParkingLot(2);
//		String registrationNumber = "reg-1", color = "black";
//		if (DataManager.parkVehicle(registrationNumber, color) != -1)
//		{
//			List<String> status = DataManager.getStatus();
//			assertEquals(1, status.size());
//		}
//	}
	
//	@Test
//	void testGetRegistrationNumbersBasedOnVehicleColor() {
//		DataManager.createParkingLot(1);
//		String registrationNumber = "reg-1", color = "black";
//		if (DataManager.parkVehicle(registrationNumber, color) != -1)
//		{
//			assertEquals(registrationNumber, DataManager.getRegistrationNumbersBasedOnVehicleColor(color).get(0));
//		}
//	}
//	
//	@Test
//	void testGetSlotNumbersBasedOnVehicleColor() {
//		DataManager.createParkingLot(1);
//		String registrationNumber = "reg-1", color = "black";
//		if (DataManager.parkVehicle(registrationNumber, color) != -1)
//		{
//			assertEquals(1, DataManager.getSlotNumbersBasedOnVehicleColor(color).get(0));
//		}
//	}
//	
//	@Test
//	void getSlotNumberBasedOnVehicleRegistrationNumber() {
//		DataManager.createParkingLot(1);
//		String registrationNumber = "reg-1", color = "black";
//		if (DataManager.parkVehicle(registrationNumber, color) != -1)
//		{
//			assertEquals(1, DataManager.getSlotNumberBasedOnVehicleRegistrationNumber(registrationNumber));
//		}
//	}
}
