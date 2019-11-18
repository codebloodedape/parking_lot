package parkinglot.commandparser;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import parkinglot.commandparser.CommandParser;
import parkinglot.datastructure.Command;

public class SlotNumbersFromColorCommandActionTest {
	
	@Test
	void testSlotNumbersFromColorCommand() {
		CommandParser parser = new CommandParser();
		Command command = new Command("CREATE_PARKING_LOT 1");
		parser.setCommand(command);
		
		parser.parse();
		
		command = new Command("park KA-01-HH-1234 White");
		parser.setCommand(command);
		
		parser.parse();
		
		String cmdString = "slot_numbers_for_cars_with_colour White";
		command = new Command(cmdString);
        parser.setCommand(command);
		
        assertTrue(parser.parse());
	}
	
	@Test
	void testBadCommand() {
		CommandParser parser = new CommandParser();
		Command command = new Command("CREATE_PARKING_LOT 1");
		parser.setCommand(command);
		
		parser.parse();
		
		command = new Command("park KA-01-HH-1234 White");
		parser.setCommand(command);
		
		parser.parse();
		
		String cmdString = "slot_numbers_for_cars_with_colour";
		command = new Command(cmdString);
        parser.setCommand(command);
        
        assertFalse(parser.parse());
	}
}
