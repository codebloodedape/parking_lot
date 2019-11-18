package parkinglot.commandparser;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import parkinglot.datastructure.Command;

public class LeaveCommandActionTest {

  @Test
  void testLeaveCommand() {
    CommandParser parser = new CommandParser();
    Command command = new Command("CREATE_PARKING_LOT 1");
    parser.setCommand(command);

    parser.parse();

    command = new Command("park KA-01-HH-1234 White");
    parser.setCommand(command);

    parser.parse();

    String cmdString = "leave 1";
    command = new Command(cmdString);
    parser.setCommand(command);

    assertTrue(parser.parse());
  }
}
