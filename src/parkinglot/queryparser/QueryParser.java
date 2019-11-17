package parkinglot.queryparser;

import parkinglot.datastructure.Query;
import parkinglot.queryparser.querychainitem.QueryChainItem;

public class QueryParser {

	private Query query;
	private QueryChainItem firstChainItem;

	/**
	 * Initializes an object of QueryParser.
	 * This also creates chain or operation
	 */
	public QueryParser() {
		// TODO update chain item here once its class is implemented
	}

	/**
	 * Sets the query object for the parsing operation to be performed
	 * @param query
	 */
	public void setQuery(Query query) {
		this.query = query;
	}

	/**
	 * Executes the chain of operations defined in the constructor
	 * @return
	 */
	public boolean execute() {
		return this.firstChainItem.parseAndUpdate(query);
	}

}
