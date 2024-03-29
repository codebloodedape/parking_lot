package parkinglot.commandparser;

import parkinglot.commandparser.commandaction.CommandAction;
import parkinglot.commandparser.commandactions.CreateParkingLotCommandAction;
import parkinglot.commandparser.commandactions.LeaveCommandAction;
import parkinglot.commandparser.commandactions.ParkVehicleCommandAction;
import parkinglot.commandparser.commandactions.RegistrationNumbersFromColorCommandAction;
import parkinglot.commandparser.commandactions.SlotNumberFromRegistrationNumberCommandAction;
import parkinglot.commandparser.commandactions.SlotNumbersFromColorCommandAction;
import parkinglot.commandparser.commandactions.StatusCommandAction;
import parkinglot.datastructure.Command;

public class CommandParser {

	private Command command;
	private CommandAction createParkingLotCommandAction;
	private CommandAction parkVehicleCommandAction;
	private CommandAction leaveCommandAction;
	private CommandAction statusCommandAction;
	private CommandAction registrationNumbersFromColorCommandAction;
	private CommandAction slotNumbersFromColorCommandAction;
	private CommandAction slotNumberFromRegistrationNumberCommandAction;

	/**
	 * Initializes an object of CommandParser.
	 * This also creates chain or operation
	 */
	public CommandParser() {
		createParkingLotCommandAction = new CreateParkingLotCommandAction();
		parkVehicleCommandAction = new ParkVehicleCommandAction();
		leaveCommandAction = new LeaveCommandAction();
		statusCommandAction = new StatusCommandAction();
		registrationNumbersFromColorCommandAction = new RegistrationNumbersFromColorCommandAction();
		slotNumbersFromColorCommandAction = new SlotNumbersFromColorCommandAction();
		slotNumberFromRegistrationNumberCommandAction = new SlotNumberFromRegistrationNumberCommandAction();
		
		createParkingLotCommandAction.setNextCommandAction(parkVehicleCommandAction);
		parkVehicleCommandAction.setNextCommandAction(leaveCommandAction);
		leaveCommandAction.setNextCommandAction(statusCommandAction);
		statusCommandAction.setNextCommandAction(registrationNumbersFromColorCommandAction);
		registrationNumbersFromColorCommandAction.setNextCommandAction(slotNumbersFromColorCommandAction);
		slotNumbersFromColorCommandAction.setNextCommandAction(slotNumberFromRegistrationNumberCommandAction);
	}

	/**
	 * Sets the query object for the parsing operation to be performed
	 * @param query
	 */
	public void setCommand(Command command) {
		this.command = command;
	}

	/**
	 * Executes the chain of operations defined in the constructor
	 * @return
	 */
	public boolean parse() {
		
		CommandAction currentCommandAction = createParkingLotCommandAction;
		
		if (currentCommandAction == null)
			return false;
		
		while (true) {
			boolean result = currentCommandAction.execute(command);
			
			if (result)
				return result;
			
			if (currentCommandAction.getNextCommandAction() == null)
				return false;
			
			currentCommandAction = currentCommandAction.getNextCommandAction();	
		}
	}

}
