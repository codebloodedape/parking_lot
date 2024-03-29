package parkinglot.datamanager;

import java.util.ArrayList;
import java.util.List;

import parkinglot.datastructure.ParkingLot;
import parkinglot.datastructure.ParkingSlot;
import parkinglot.datastructure.Vehicle;
import parkinglot.datastructure.exceptions.NoParkingLotException;

public class DataManager {
    private static ParkingLot parkingLot;

    public static ParkingLot getParkingLot() 
    {
		return parkingLot;
	}

	/**
     * Creates parking lot with specified number of slots
     * @param slotCount Number of slots
     */
    public static void createParkingLot(int slotCount)
    {
        parkingLot = new ParkingLot(slotCount);
    }

    /**
     * Creates a vehicle from the vehicle information and updates the Parking Lot
     * @param registrationNumber Registration number of the vehicle
     * @param color Color of the vehicle
     * @return The slot number of the newly allocated slot. Returns -1 if slot could not be allocated.
     * @throws NoParkingLotException 
     */
    public static int parkVehicle(String registrationNumber, String color) throws NoParkingLotException
    {
    	if (parkingLot == null) {
    		throw new NoParkingLotException();
    	}

    	Vehicle car = new Vehicle();
        car.setRegistrationNumber(registrationNumber);
        car.setColor(color);

        ParkingSlot slot = parkingLot.Park(car);
        return slot == null ? -1 : slot.getSlotNumber();
    }

    /**
     * Removes the vehicle that was parked in the specified slot
     * @param slotNumber slot number of the vehicle
     * @return Returns the slot number, if successful. Returns -1, if failed
     */
    public static int leave(int slotNumber) throws NoParkingLotException
    {
    	if (parkingLot == null)
    		throw new NoParkingLotException();
    	
        return parkingLot.Leave(slotNumber);
    }

    /**
     * Gets the list of all the slots that are occupied
     * @return Returns the list of occupied slots
     */
    public static List<ParkingSlot> getStatus() throws NoParkingLotException
    {
    	if (parkingLot == null)
    		throw new NoParkingLotException();
    	
        List<ParkingSlot> filledSlots = new ArrayList<ParkingSlot>();
        
        for (ParkingSlot slot : parkingLot.getSlots())
        {
            if (!slot.isAvailable())
            	filledSlots.add(slot);
        }
        
        return filledSlots;
    }

    /**
     * Gets the list of registration numbers of all the vehicles with specified color.
     * @param color Color of the vehicle
     * @return List of registration numbers
     */
    public static List<String> getRegistrationNumbersBasedOnVehicleColor(String color) throws NoParkingLotException
    {
    	if (parkingLot == null)
    		throw new NoParkingLotException();
    	
        List<String> registrationNumbers = new ArrayList<String>();

        for (ParkingSlot slot : parkingLot.getSlots())
        {
            if (!slot.isAvailable() && slot.getVehicle().getColor().equalsIgnoreCase(color))
                registrationNumbers.add(slot.getVehicle().getRegistrationNumber());
        }

        return registrationNumbers;
    }

    /**
     * Gets the list of slot numbers which has the specified color vehicle
     * @param color Color of the vehicle
     * @return Returns the list of slot numbers
     */
    public static List<Integer> getSlotNumbersBasedOnVehicleColor(String color) throws NoParkingLotException
    {
    	if (parkingLot == null)
    		throw new NoParkingLotException();
    	
        List<Integer> slotNumbers = new ArrayList<Integer>();

        for (ParkingSlot slot : parkingLot.getSlots())
        {
            if (!slot.isAvailable() && slot.getVehicle().getColor().equalsIgnoreCase(color))
                slotNumbers.add(slot.getSlotNumber());
        }

        return slotNumbers;
    }

    /**
     * Gets the slot number which has vehicle with specified registration number
     * @param registrationNumber
     * @return Return the slot number if found, else return -1
     */
    public static int getSlotNumberBasedOnVehicleRegistrationNumber(String registrationNumber) throws NoParkingLotException
    {
    	if (parkingLot == null)
    		throw new NoParkingLotException();
    	
        for (ParkingSlot slot : parkingLot.getSlots())
        {
            if (slot.getVehicle().getRegistrationNumber().equalsIgnoreCase(registrationNumber))
                return slot.getSlotNumber();
        }

        return -1;
    }
}
