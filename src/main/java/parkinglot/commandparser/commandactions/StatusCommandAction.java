package parkinglot.commandparser.commandactions;

import java.util.List;

import parkinglot.commandparser.commandaction.CommandAction;
import parkinglot.datamanager.DataManager;
import parkinglot.datastructure.Command;
import parkinglot.datastructure.ParkingSlot;
import parkinglot.datastructure.exceptions.NoParkingLotException;

public class StatusCommandAction extends CommandAction {
	String identifier = "STATUS";
	
	@Override
	public boolean execute(Command command)
    {
		if (command.inputText.equalsIgnoreCase(identifier))
        {
			List<ParkingSlot> filledSlots = null;
			try {
				filledSlots = DataManager.getStatus();	
			}
			catch (NoParkingLotException ex) {
        		command.outputText = "Parking lot not available. Please create one and then check the status";
        		return true;
        	}
            
			if (filledSlots != null && filledSlots.size() > 0) {
				StringBuilder outputText = new StringBuilder();
	            outputText.append("Slot No.\t\tRegistration No.\t\tColour");
	            
	            for (ParkingSlot filledSlot : filledSlots)
	                outputText.append(filledSlot.getSlotNumber() + "\t\t" + filledSlot.getVehicle().getRegistrationNumber() +
	                		"\t\t" + filledSlot.getVehicle().getColor());
	            
	            command.outputText = outputText.toString();	
			}
			else
				command.outputText = "Not Found";
			
            return true;
        }
		return false;
    }
}
