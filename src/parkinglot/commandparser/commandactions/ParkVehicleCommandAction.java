package parkinglot.commandparser.commandactions;

import parkinglot.commandparser.commandaction.CommandAction;
import parkinglot.datastructure.Command;

public class ParkVehicleCommandAction extends CommandAction {
	String identifier = "PARK";
	
	@Override
    public boolean execute(Command command)
    {
        String[] queryStringParts = command.inputText.split(" ");

        if (queryStringParts.length == 3 && queryStringParts[0].trim().equalsIgnoreCase(identifier))
        {
            int slotNumber = -1;
            
            // TODO implement BL
            
            if (slotNumber != -1)
            	command.outputText = "Allocated slot number: " + slotNumber;
            else
            	command.outputText = "Sorry, parking lot is full";
            
            return true;
        }
        return false;
    }
}
