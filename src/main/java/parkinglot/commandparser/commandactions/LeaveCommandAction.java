package parkinglot.commandparser.commandactions;

import parkinglot.commandparser.commandaction.CommandAction;
import parkinglot.datamanager.DataManager;
import parkinglot.datastructure.Command;
import parkinglot.datastructure.exceptions.NoParkingLotException;

public class LeaveCommandAction extends CommandAction {
	String identifier = "LEAVE";
	
	@Override
	public boolean execute(Command command)
    {
        String[] queryStringParts = command.inputText.split(" ");
        if (queryStringParts.length == 2 && queryStringParts[0].trim().equalsIgnoreCase(identifier))
        {
        	int value;
        	try {
        		value = Integer.parseInt(queryStringParts[1].trim());	
        	}
        	catch(NumberFormatException ex) {
        		command.outputText = "Invalid number " + queryStringParts[1] + 
        				". Provide a proper number.";
        		return true;
        	}
        	int slotNumber = -1;
        	try {
        		slotNumber = DataManager.leave(value);
        	}
        	catch (NoParkingLotException ex) {
        		command.outputText = "Create a parking log and park the vehicle before leaving";
        		return true;
        	}
            if (slotNumber != -1)
            	command.outputText = "Slot number " + slotNumber + " is free";
            else
            	command.outputText = "Slot number " + slotNumber + " does not exist";

            return true;
        }
        return false;
    }
}
