package parkinglot.datastructure;

public class Command {
	
    /**
     * InputText contains the string of a specific type, that is to be parsed
     */
    public String inputText;

    /**
     * OutputText contains the string to be displayed on the STD OUT, after processing.
     */
    public String outputText;

    /**
     * Initializes an object of Query
     * @param inputText Input text to be parsed
     */
    public Command(String inputText)
    {
        this.inputText = inputText;
        this.outputText = "";
    }
}
