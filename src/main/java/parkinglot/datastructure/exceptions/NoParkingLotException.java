package parkinglot.datastructure.exceptions;

public class NoParkingLotException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoParkingLotException() {
		super();
	}
	
	@Override
	public String getMessage() {
		return "Parking lot has not been created before operating on it";
	}
}
