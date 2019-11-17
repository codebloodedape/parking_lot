package parkinglot.test.commandparser;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import parkinglot.commandparser.CommandParser;
import parkinglot.datastructure.Command;

public class RegistrationNumbersFromColorCommandActionTest {
	
	@Test
	void testRegistrationNumbersFromColorCommand() {
		CommandParser parser = new CommandParser();
		String cmdString = "registration_numbers_for_cars_with_colour White";
		Command command = new Command(cmdString);
        parser.setCommand(command);
        
        assertTrue(parser.parse());
	}
	
	@Test
	void testBadCommand() {
		CommandParser parser = new CommandParser();
		String cmdString = "registration_numbers_for_cars_with_colour White q";
		Command command = new Command(cmdString);
        parser.setCommand(command);
        
        assertFalse(parser.parse());
	}
}
