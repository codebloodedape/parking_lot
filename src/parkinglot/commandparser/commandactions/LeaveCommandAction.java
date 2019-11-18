package parkinglot.commandparser.commandactions;

import parkinglot.commandparser.commandaction.CommandAction;
import parkinglot.datamanager.DataManager;
import parkinglot.datastructure.Command;

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
        				". Please provide a proper number.";
        		return false;
        	}
        	int slotNumber = DataManager.leave(value);
            if (slotNumber != -1)
            	command.outputText = "Slot number " + slotNumber + " is free";
            else
            	command.outputText = "Slot number " + slotNumber + " does not exist";

            return true;
        }
        return false;
    }
}
