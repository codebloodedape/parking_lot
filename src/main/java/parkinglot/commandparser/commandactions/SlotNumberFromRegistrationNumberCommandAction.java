package parkinglot.commandparser.commandactions;

import parkinglot.commandparser.commandaction.CommandAction;
import parkinglot.datamanager.DataManager;
import parkinglot.datastructure.Command;
import parkinglot.datastructure.exceptions.NoParkingLotException;

public class SlotNumberFromRegistrationNumberCommandAction extends CommandAction {
	String identifier = "SLOT_NUMBER_FOR_REGISTRATION_NUMBER";
	
	@Override
	public boolean execute(Command command)
    {
		String[] queryStringParts = command.inputText.split(" ");

        if (queryStringParts.length == 2 && queryStringParts[0].trim().equalsIgnoreCase(identifier))
        {
        	int slotNumber = -1;
        	try {
        		slotNumber = DataManager.getSlotNumberBasedOnVehicleRegistrationNumber(queryStringParts[1].trim());
        	}
        	catch (NoParkingLotException ex) {
        		command.outputText = "Create a parking lot before trying to query the list of slot numbers";
        		return true;
        	}
        	command.outputText = slotNumber == -1 ? "Not found" : Integer.toString(slotNumber);
            return true;
        }
		return false;
    }
}
