package parkinglot.commandparser;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import parkinglot.commandparser.CommandParser;
import parkinglot.datastructure.Command;

public class StatusCommandActionTest {
	
	@Test
	void testStatusCommand() {
		CommandParser parser = new CommandParser();
		Command command = new Command("CREATE_PARKING_LOT 2");
		parser.setCommand(command);
		
		parser.parse();
		
		command = new Command("park KA-01-HH-1234 White");
		parser.setCommand(command);
		
		parser.parse();
		
		String cmdString = "status";
		command = new Command(cmdString);
        parser.setCommand(command);
        
        assertTrue(parser.parse());
	}
	
	@Test
	void testBadCommand() {
		CommandParser parser = new CommandParser();
		Command command = new Command("CREATE_PARKING_LOT 2");
		parser.setCommand(command);
		
		parser.parse();
		
		command = new Command("park KA-01-HH-1234 White");
		parser.setCommand(command);
		
		parser.parse();
		
		String cmdString = "status 1";
		command = new Command(cmdString);
        parser.setCommand(command);
        
        assertFalse(parser.parse());
	}
}
