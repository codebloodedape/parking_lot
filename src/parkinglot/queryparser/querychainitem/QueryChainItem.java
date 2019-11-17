package parkinglot.queryparser.querychainitem;

import parkinglot.datastructure.Query;

public abstract class QueryChainItem {
	
	/**
	 * This contains the next object of the QueryChainItem that is in the list,
	 * and that is to be parsed according to, in case if the current QueryChainItem 
	 * object is unable to parse the query.
	 */
	private QueryChainItem nextQueryChainItem;

	public QueryChainItem getNextQueryChainItem() {
		return nextQueryChainItem;
	}

	public void setNextQueryChainItem(QueryChainItem nextQueryChainItem) {
		this.nextQueryChainItem = nextQueryChainItem;
	}

	/**
	 * Parses and updates query.
	 * @param query Query object to be processed
	 * @return True, if the query was parsed and processed successfully, else, False
	 */
	public abstract boolean parseAndUpdate(Query query);
}
