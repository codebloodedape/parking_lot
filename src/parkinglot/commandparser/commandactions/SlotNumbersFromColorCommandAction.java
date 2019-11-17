package parkinglot.commandparser.commandactions;

import parkinglot.commandparser.commandaction.CommandAction;
import parkinglot.datastructure.Command;

public class SlotNumbersFromColorCommandAction extends CommandAction {
	String identifier = "SLOT_NUMBERS_FOR_CARS_WITH_COLOUR";
	
	@Override
	public boolean execute(Command command)
    {
		String[] queryStringParts = command.inputText.split(" ");

        if (queryStringParts.length == 2 && queryStringParts[0].trim().equalsIgnoreCase(identifier))
        {
        	// TODO implement BL
            return true;
        }
		return false;
    }
}
