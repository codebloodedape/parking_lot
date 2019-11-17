package parkinglot.test.commandparser;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import parkinglot.commandparser.CommandParser;
import parkinglot.datastructure.Command;

public class LeaveCommandActionTest {
	
	@Test
	void testLeaveCommand() {
		CommandParser parser = new CommandParser();
		String cmdString = "leave 4";
		Command command = new Command(cmdString);
        parser.setCommand(command);
        
        assertTrue(parser.parse());
	}
	
	@Test
	void testBadNumberLeaveCommand() {
		CommandParser parser = new CommandParser();
		String cmdString = "leave 4a";
		Command command = new Command(cmdString);
        parser.setCommand(command);
        
        assertFalse(parser.parse());
	}
}
