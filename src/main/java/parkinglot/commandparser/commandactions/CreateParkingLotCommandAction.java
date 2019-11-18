package parkinglot.commandparser.commandactions;

import parkinglot.commandparser.commandaction.CommandAction;
import parkinglot.datamanager.DataManager;
import parkinglot.datastructure.Command;

public class CreateParkingLotCommandAction extends CommandAction {

	String identifier = "CREATE_PARKING_LOT";
    
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
        	DataManager.createParkingLot(value);
            command.outputText = "Created a parking lot with " + (value) + " slots";
            return true;
        }
        return false;
    }
}
