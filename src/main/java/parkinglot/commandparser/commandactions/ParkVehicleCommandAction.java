package parkinglot.commandparser.commandactions;

import parkinglot.commandparser.commandaction.CommandAction;
import parkinglot.datamanager.DataManager;
import parkinglot.datastructure.Command;
import parkinglot.datastructure.exceptions.NoParkingLotException;

public class ParkVehicleCommandAction extends CommandAction {
	String identifier = "PARK";
	
	@Override
    public boolean execute(Command command)
    {
        String[] queryStringParts = command.inputText.split(" ");
        if (queryStringParts.length == 3 && queryStringParts[0].trim().equalsIgnoreCase(identifier))
        {
        	int slotNumber = 1;
        	try {
        		slotNumber = DataManager.parkVehicle(queryStringParts[1].trim(), queryStringParts[2].trim());	
        	}
        	catch (NoParkingLotException ex) {
        		command.outputText = "Create a parking lot before parking the vechile";
        		return true;
        	}
            if (slotNumber != -1)
            	command.outputText = "Allocated slot number: " + slotNumber;
            else
            	command.outputText = "Sorry, parking lot is full";
            
            return true;
        }
        return false;
    }
}