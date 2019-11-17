package parkinglot.test.commandparser;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import parkinglot.commandparser.CommandParser;
import parkinglot.datastructure.Command;

public class ParkVehicleCommandActionTest {
	
	@Test
	void testParkCommand() {
		CommandParser parser = new CommandParser();
		String cmdString = "park KA-01-HH-1234 White";
		Command command = new Command(cmdString);
        parser.setCommand(command);
        
        assertTrue(parser.parse());
	}
	
	@Test
	void testBadParkCommand() {
		CommandParser parser = new CommandParser();
		String cmdString = "park KA-01-HH-1234 White q";
		Command command = new Command(cmdString);
        parser.setCommand(command);
        
        assertFalse(parser.parse());
	}
}
