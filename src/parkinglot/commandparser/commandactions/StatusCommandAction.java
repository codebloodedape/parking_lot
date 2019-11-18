package parkinglot.commandparser.commandactions;

import java.util.List;

import parkinglot.commandparser.commandaction.CommandAction;
import parkinglot.datamanager.DataManager;
import parkinglot.datastructure.Command;

public class StatusCommandAction extends CommandAction {
	String identifier = "STATUS";
	
	@Override
	public boolean execute(Command command)
    {
		if (command.inputText.equalsIgnoreCase(identifier))
        {
			List<String> filledSlots = DataManager.getStatus();
            
			if (filledSlots.size() > 0) {
				StringBuilder outputText = new StringBuilder();
	            outputText.append("Slot No.\t\tRegistration No.\t\tColour");
	            
	            for (String filledSlot : filledSlots)
	                outputText.append(filledSlot);
	            
	            command.outputText = outputText.toString();	
			}
			else
				command.outputText = "Not Found";
			
            return true;
        }
		return false;
    }
}
