package parkinglot.commandparser.commandactions;

import java.util.List;

import parkinglot.commandparser.commandaction.CommandAction;
import parkinglot.datamanager.DataManager;
import parkinglot.datastructure.Command;
import parkinglot.datastructure.exceptions.NoParkingLotException;

public class RegistrationNumbersFromColorCommandAction extends CommandAction {
	String identifier = "REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR";
	
	@Override
	public boolean execute(Command command)
    {
		String[] queryStringParts = command.inputText.split(" ");

        if (queryStringParts.length == 2 && queryStringParts[0].trim().equalsIgnoreCase(identifier))
        {
        	List<String> registrationNumberList = null;
        	try {
        		registrationNumberList = DataManager.getRegistrationNumbersBasedOnVehicleColor(queryStringParts[1].trim());	
        	}
        	catch (NoParkingLotException ex) {
        		command.outputText = "Create a parking lot before trying to query the list of registration numbers";
        		return true;
        	}
        	
            if (registrationNumberList != null && registrationNumberList.size() > 0)
            {
                StringBuilder outputText = new StringBuilder();

                for (String registrationNumber : registrationNumberList)
                    outputText.append(registrationNumber + ", ");

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
