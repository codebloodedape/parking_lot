package parkinglot.commandparser.commandaction;

import parkinglot.datastructure.Command;

public abstract class CommandAction {
	
	/**
	 * This contains the next object of the QueryChainItem that is in the list,
	 * and that is to be parsed according to, in case if the current QueryChainItem 
	 * object is unable to parse the query.
	 */
	private CommandAction nextCommandAction;

	public CommandAction getNextCommandAction() {
		return nextCommandAction;
	}

	public void setNextCommandAction(CommandAction nextQueryChainItem) {
		this.nextCommandAction = nextQueryChainItem;
	}
	
	public CommandAction() {
		this.nextCommandAction = null;
	}

	/**
	 * Parses and updates query.
	 * @param command Query object to be processed
	 * @return True, if the query was parsed and processed successfully, else, False
	 */
	public abstract boolean execute(Command command);
}
