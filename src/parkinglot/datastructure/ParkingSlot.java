package parkinglot.datastructure;

public class ParkingSlot {
	private int slotNumber;
    private boolean isAvailable;
    private Vehicle vehicle;

    public int getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ParkingSlot(int slotNumber)
    {
        isAvailable = true;
        this.slotNumber = slotNumber;
    }

	public void Park(Vehicle car)
    {
        this.vehicle = car;
        this.isAvailable = false;
    }

	public void Leave()
    {
        this.vehicle = null;
        this.isAvailable = true;
    }
}
