package parkinglot.commandparser.commandactions;

import parkinglot.commandparser.commandaction.CommandAction;
import parkinglot.datastructure.Command;

public class StatusCommandAction extends CommandAction {
	String identifier = "STATUS";
	
	@Override
	public boolean execute(Command command)
    {
		if (command.inputText.equalsIgnoreCase(identifier))
        {
			String []filledSlots = new String[1];
            //TODO implement BL
			if (filledSlots.length > 0) {
				StringBuilder outputText = new StringBuilder();
	            outputText.append("Slot No.\tRegistration No\tColour\n");
	            
	            for (String filledSlot : filledSlots)
	                outputText.append(filledSlot);
	            
	            command.outputText = outputText.toString();	
			}
			else
				command.outputText = "No records found";
			
            return true;
        }
		return false;
    }
}
