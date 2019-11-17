package parkinglot.test.commandparser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import parkinglot.commandparser.CommandParser;
import parkinglot.datastructure.Command;

class CreateParkingLotCommandActionTest {
	@Test
	void testParkingLotCreationCommand() {
		CommandParser parser = new CommandParser();
		String cmdString = "CREATE_PARKING_LOT 1";
		Command command = new Command(cmdString);
        parser.setCommand(command);
        
        assertTrue(parser.parse());
	}
	
	@Test
	void testBadCommand() {
		CommandParser parser = new CommandParser();
		String cmdString = "CREATE_PARKING_LO 1";
		Command command = new Command(cmdString);
        parser.setCommand(command);
        
        assertFalse(parser.parse());
	}
	
	@Test
	void testBadNumberCommand() {
		CommandParser parser = new CommandParser();
		String cmdString = "CREATE_PARKING_LOT 1a";
		Command command = new Command(cmdString);
        parser.setCommand(command);
        
        assertFalse(parser.parse());
	}

}
