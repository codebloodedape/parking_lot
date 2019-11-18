package parkinglot.commandparser;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import parkinglot.commandparser.CommandParser;
import parkinglot.datastructure.Command;

public class ParkVehicleCommandActionTest {
	
	@Test
	void testParkCommand() {
		CommandParser parser = new CommandParser();
		Command command = new Command("CREATE_PARKING_LOT 1");
		parser.setCommand(command);
		
		parser.parse();
		
		command = new Command("park KA-01-HH-1234 White");
		parser.setCommand(command);
		
        assertTrue(parser.parse());
	}
	
	@Test
	void testBadParkCommand() {
		CommandParser parser = new CommandParser();
		Command command = new Command("CREATE_PARKING_LOT 1");
		parser.setCommand(command);
		
		parser.parse();
		
		command = new Command("park KA-01-HH-1234 White a");
		parser.setCommand(command);
        
        assertFalse(parser.parse());
	}
}
