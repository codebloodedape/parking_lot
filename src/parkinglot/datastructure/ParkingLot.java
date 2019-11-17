package parkinglot.datastructure;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	private List<ParkingSlot> slots;

    public List<ParkingSlot> getSlots() {
		return slots;
	}

	public void setSlots(List<ParkingSlot> slots) {
		this.slots = slots;
	}

	public ParkingLot(int slotCount)
    {
    	slots = new ArrayList<ParkingSlot>(slotCount);
        for (int i = 1; i <= slotCount; i++)
        {
        	slots.add(new ParkingSlot(i));
        }
    }

    public ParkingSlot Park(Vehicle car)
    {
        for (ParkingSlot slot : slots)
        {
            if (slot.isAvailable())
            {
                slot.Park(car);
                return slot;
            }
        }
        return null;
    }

    public int Leave(int slotNumber)
    {
        for (ParkingSlot slot : slots)
        {
            if (slot.getSlotNumber() == slotNumber)
            {
                slot.Leave();
                return slotNumber;
            }
        }
        return -1;
    }

    public List<ParkingSlot> GetSlotsBasedOnCarColor(String color)
    {
        List<ParkingSlot> result = new ArrayList<ParkingSlot>();
        for (ParkingSlot slot : slots)
        {
            if (slot.isAvailable() && slot.getVehicle().getColor().equalsIgnoreCase(color))
            {
                result.add(slot);
            }
        }
        return result;
    }

    public List<ParkingSlot> GetSlotsBasedOnRegistrationNumber(String registrationNumber)
    {
        List<ParkingSlot> result = new ArrayList<ParkingSlot>();
        for (ParkingSlot slot : slots)
        {
            if (slot.isAvailable() && slot.getVehicle().getRegistrationNumber().equalsIgnoreCase(registrationNumber))
            {
                result.add(slot);
            }
        }
        return result;
    }
}
