package parkinglot.test.commandparser;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import parkinglot.commandparser.CommandParser;
import parkinglot.datastructure.Command;

public class SlotNumberFromRegistrationNumberCommandActionTest {
	
	@Test
	void testStatusCommand() {
		CommandParser parser = new CommandParser();
		String cmdString = "slot_number_for_registration_number KA-01-HH-3141";
		Command command = new Command(cmdString);
        parser.setCommand(command);
        
        assertTrue(parser.parse());
	}
	
	@Test
	void testBadCommand() {
		CommandParser parser = new CommandParser();
		String cmdString = "slot_number_for_registration_number";
		Command command = new Command(cmdString);
        parser.setCommand(command);
        
        assertFalse(parser.parse());
	}
}
