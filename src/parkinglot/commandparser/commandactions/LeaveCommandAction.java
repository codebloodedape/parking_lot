package parkinglot.commandparser.commandactions;

import parkinglot.commandparser.commandaction.CommandAction;
import parkinglot.datastructure.Command;

public class LeaveCommandAction extends CommandAction  {
	String identifier = "LEAVE";
	
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
        	int slotNumber = -1;
        	// TODO implement BL

            if (slotNumber != -1)
            	command.outputText = "Slot number " + slotNumber + " is free";
            else
            	command.outputText = "Slot number " + slotNumber + " does not exist";

            return true;
        }
        return false;
    }
}
