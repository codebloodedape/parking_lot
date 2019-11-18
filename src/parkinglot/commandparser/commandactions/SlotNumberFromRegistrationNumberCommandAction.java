package parkinglot.commandparser.commandactions;

import parkinglot.commandparser.commandaction.CommandAction;
import parkinglot.datamanager.DataManager;
import parkinglot.datastructure.Command;

public class SlotNumberFromRegistrationNumberCommandAction extends CommandAction {
	String identifier = "SLOT_NUMBER_FOR_REGISTRATION_NUMBER";
	
	@Override
	public boolean execute(Command command)
    {
		String[] queryStringParts = command.inputText.split(" ");

        if (queryStringParts.length == 2 && queryStringParts[0].trim().equalsIgnoreCase(identifier))
        {
        	int slotNumber = DataManager.getSlotNumberBasedOnVehicleRegistrationNumber(queryStringParts[1].trim());
        	command.outputText = slotNumber == -1 ? "Not found" : Integer.toString(slotNumber);
            return true;
        }
		return false;
    }
}
