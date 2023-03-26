package telran.util;

import java.util.HashMap;
import java.util.LinkedList;

public class ConnectionsPoolSol implements ConnectionsPool {
	Integer currentId;
	int maxSizeOfPool = 5;
	LinkedList<Integer> listId = new LinkedList<>();
	HashMap<Integer, Connection> pool = new HashMap<>();

	@Override
	public boolean addConnection(Connection connection) {
		currentId = connection.getId();
		boolean res = false;
		if (!pool.containsKey(currentId)) {
			addNewConnection(connection);
			res = true;
		} else {
			replaceConnection(connection);
		}
		return res;
	}

	private void addNewConnection(Connection connection) {
		if (pool.size() == maxSizeOfPool) {
			Integer lastConnect = listId.removeLast();
			pool.remove(lastConnect);
		}
		listId.addFirst(currentId);
		pool.put(currentId, connection);
	}
	
	private void replaceConnection(Connection connection) {
		listId.remove(currentId);
		listId.addFirst(currentId);;
		pool.put(currentId, connection);
	}

	@Override
	public Connection getConnection(int id) {
		currentId = id;
		Connection res = pool.get(currentId);
		
		if(res != null) {
			replaceConnection(res);
		}
		return res;
	}
	
	public LinkedList<Integer> getUsingOrder(){
		return listId;
	}

}
