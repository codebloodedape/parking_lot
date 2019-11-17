package parkinglot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import parkinglot.commandparser.CommandParser;
import parkinglot.datastructure.Command;

public class ConsoleInterface {

	/**
	 * Main method of the entry Class ConsoleInterface. 
	 * This method will take the first argument, if provided, for the path of the command file,
	 * else, read commands from the console
	 * @param args array of arguments. The command file path should be the first argument in the array.
	 */
	public static void main(String []args) {
        if (args.length == 0)
        {
            System.out.println("Interactive mode");
            Scanner stdInScanner = new Scanner(System.in);
            try {
            	System.out.println("Enter commands/queries below(enter 'exit' to quit):");
            	String line;
            	
        		while (true) {
        			line = stdInScanner.nextLine().trim();
        			if (line.equalsIgnoreCase("EXIT")) {
        				System.out.println("Exiting.");
        				return;
        			}
        			processQuery(line);
        		}
            }
            finally {
            	stdInScanner.close();
            }
        }
        else
        {
            String commandFilePath = args[0];
            System.out.println("File mode");
			try {
				Scanner fileScanner = new Scanner(new File(commandFilePath));
				System.out.println("Commands/Queries are read from " + commandFilePath + ".");
				while (fileScanner.hasNextLine()) {
					String line = fileScanner.nextLine().trim();
					System.out.println(line);
					processQuery(line);
				}
				System.out.println("Exiting.");
				fileScanner.close();
			} catch (FileNotFoundException e) {
				System.out.println("The file " + commandFilePath + " could not be founud. "
						+ "Check if the command file exists in the specified location before "
						+ "restarting this application.");
			}
        }
	}
	
	private static void processQuery(String line)
    {
		CommandParser parser = new CommandParser();
		Command command = new Command(line);
        parser.setCommand(command);

        boolean result = parser.parse();
        
        if (command.outputText != "")
        	System.out.println(command.outputText);
        else {
        	if (!result)
        		System.out.println("Could not parse the command");
        }
    }
}
