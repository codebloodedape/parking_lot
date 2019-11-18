package parkinglot.commandparser.commandactions;

import java.util.List;

import parkinglot.commandparser.commandaction.CommandAction;
import parkinglot.datamanager.DataManager;
import parkinglot.datastructure.Command;
import parkinglot.datastructure.exceptions.NoParkingLotException;

public class SlotNumbersFromColorCommandAction extends CommandAction {
	String identifier = "SLOT_NUMBERS_FOR_CARS_WITH_COLOUR";
	
	@Override
	public boolean execute(Command command)
    {
		String[] queryStringParts = command.inputText.split(" ");

        if (queryStringParts.length == 2 && queryStringParts[0].trim().equalsIgnoreCase(identifier))
        {
        	List<Integer> slotNumbers = null;
        	try {
        		slotNumbers = DataManager.getSlotNumbersBasedOnVehicleColor(queryStringParts[1].trim());	
        	}
        	catch (NoParkingLotException ex) {
        		command.outputText = "Create a parking lot before trying to query the list of slot numbers";
        		return true;
        	}
        	
            if (slotNumbers != null && slotNumbers.size() > 0)
            {
                StringBuilder outputText = new StringBuilder();

                for (int slotNumber : slotNumbers)
                    outputText.append(slotNumber + ", ");

                outputText.delete(outputText.length() - 2, outputText.length() - 1);
                command.outputText = outputText.toString();
            }
            else
            	command.outputText = "Not Found";
            
            return true;
        }
		return false;
    }
}
